package business.game;

import business.interceptingfilter.MultiplayerFilter;
import business.proxy.IPlayer;
import business.proxy.ProxyPlayer;
import business.service.king.IKingService;
import business.service.king.KingService;
import business.service.moves.IPieceMoveService;
import business.service.moves.impl.PieceMoveServiceImpl;
import util.ColorOfPiece;
import business.game.state.*;
import business.pieces.ChessGamePiece;
import business.pieces.King;
import gui.ChessPanel;
import gui.board.BoardSquare;
import gui.board.ChessGameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executors;

import static business.interceptingfilter.MultiplayerFilter.MULTIPLAYER_MODE;

/**
 * This is the backend behind the Chess game. Handles the turn-based aspects of
 * the game, click events, and determines win/lose conditions.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class ChessGameEngine {

    private String SOCKET_SERVER_ADDR = "localhost";
    private int PORT = 50000;


    private ChessGamePiece currentPiece;
    private boolean firstClick;
    private IPlayer currentPlayer;
    private ChessGameBoard board;
    private IPieceMoveService pieceMoveService;
    private IKingService kingService;
    private King king1;
    private King king2;
    private State state;

    private ServerSocket listener;
    private Socket socket;
    private PrintWriter printWriter;


    /**
     * Create a new ChessGameEngine object. Accepts a fully-created
     * ChessGameBoard. (i.e. all components rendered)
     *
     * @param board the reference ChessGameBoard
     */
    public ChessGameEngine(ChessGameBoard board) {
        firstClick = true;
        currentPlayer = new ProxyPlayer(1);
        this.board = board;
        this.king1 = (King) board.getCell(7, 4).getPieceOnSquare();
        this.king2 = (King) board.getCell(0, 4).getPieceOnSquare();
        ((ChessPanel) board.getParent()).getGameLog().clearLog();
        ((ChessPanel) board.getParent()).getGameLog().addToLog(
                "A new chess "
                        + "game has been started. Player 1 (white) will play "
                        + "against Player 2 (black). BEGIN!");

        pieceMoveService = PieceMoveServiceImpl.getInstance();
        kingService = KingService.getInstance(board, pieceMoveService);
        setState(new NormalState(this,board,king1,king2));
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        state.update();
        this.state = state;
    }

    /**
     * Determines if the requested player has legal moves.
     *
     * @param playerNum the player to check
     * @return boolean true if the player does have legal moves, false otherwise
     */
    public boolean playerHasLegalMoves(int playerNum) {
        ArrayList<ChessGamePiece> pieces;
        if (playerNum == 1) {
            pieces = board.getAllWhitePieces();
        } else if (playerNum == 2) {
            pieces = board.getAllBlackPieces();
        } else {
            return false;
        }
        for (ChessGamePiece currPiece : pieces) {
            if (pieceMoveService.hasLegalMoves(board,currPiece)) {
                return true;
            }
        }
        return false;
    }
//_____________________________________________________________________________________________________________________

    /**
     * Resets the game to its original state.
     */
    public void reset() {
        firstClick = true;
        currentPlayer = new ProxyPlayer(1);
        ((ChessPanel) board.getParent()).getGraveyard(1).clearGraveyard();
        ((ChessPanel) board.getParent()).getGraveyard(2).clearGraveyard();
        ((ChessPanel) board.getParent()).getGameBoard().initializeBoard();
        ((ChessPanel) board.getParent()).revalidate();
        this.king1 = (King) board.getCell(7, 4).getPieceOnSquare();
        this.king2 = (King) board.getCell(0, 4).getPieceOnSquare();
        ((ChessPanel) board.getParent()).getGameLog().clearLog();
        ((ChessPanel) board.getParent()).getGameLog().addToLog(
                "A new chess "
                        + "game has been started. Player 1 (white) will play "
                        + "against Player 2 (black). BEGIN!");
        state.changeState(new NormalState(this,board,king1,king2));
    }

    /**
     * Resets the game to its save state.
     */
    public void restaurar(BoardSquare[][] boardSquare, int currentPlayer) {
        firstClick = true;
        ((ChessPanel) board.getParent()).getGraveyard(1).clearGraveyard();
        ((ChessPanel) board.getParent()).getGraveyard(2).clearGraveyard();
        ((ChessPanel) board.getParent()).getGameBoard().restaurarBoard(boardSquare, this);
        this.currentPlayer = new ProxyPlayer(currentPlayer);
        checkGameConditions(false);
        ((ChessPanel) board.getParent()).revalidate();
        ((ChessPanel) board.getParent()).getGameLog().clearLog();
        ((ChessPanel) board.getParent()).getGameLog().addToLog(
                "Restaurado!");
    }


    /**
     * Gets the current player. Used for determining the turn.
     *
     * @return int the current player (1 or 2)
     */

    public IPlayer getCurrentPlayer() {
        return currentPlayer;
    }


    /**
     * Switches the turn to be the next player's turn.
     */
    private void nextTurn() {
    currentPlayer = new ProxyPlayer(currentPlayer.allowPlay() == 1 ? 2 : 1);
        ((ChessPanel) board.getParent()).getGameLog().addToLog(
                "It is now Player " + currentPlayer.allowPlay() + "'s turn.");
    }

    /**
     * Checks if the last-clicked piece is a valid piece (i.e. if it is
     * the correct color and if the user actually clicked ON a piece.)
     *
     * @return boolean true if the piece is valid, false otherwise
     */
    private boolean selectedPieceIsValid() {
        if (currentPiece == null) // user tried to select an empty square
        {
            return false;
        }
        if (currentPlayer.allowPlay() == 2) // black player
        {
            if (currentPiece.getColorOfPiece().getColor() == ColorOfPiece.BLACK) {
                return true;
            }
            return false;
        } else
        // white player
        {
            if (currentPiece.getColorOfPiece().getColor() == ColorOfPiece.WHITE) {
                return true;
            }
            return false;
        }
    }

    /**
     * Determines if the requested King is in check.
     *
     * @param checkCurrent if true, will check if the current king is in check if false,
     *                     will check if the other player's king is in check.
     * @return true if the king is in check, false otherwise
     */
    public boolean isKingInCheck(boolean checkCurrent) {
        if (checkCurrent) {
            if (currentPlayer.allowPlay() == 1) {
                return kingService.isChecked(king1);
            }
            return kingService.isChecked(king2);
        } else {
            if (currentPlayer.allowPlay() == 2) {
                return kingService.isChecked(king1);
            }
            return kingService.isChecked(king2);
        }
    }

    /**
     * Asks the user if they want to play again - if they don't, the game exits.
     *
     * @param endGameStr the string to display to the user (i.e. stalemate, checkmate,
     *                   etc)
     */
    private void askUserToPlayAgain(String endGameStr) {
        int resp =
                JOptionPane.showConfirmDialog(board.getParent(), endGameStr
                        + " Do you want to play again?");
        if (resp == JOptionPane.YES_OPTION) {
            reset();
        } else {
            board.resetBoard(false);
            // System.exit(0);
        }
    }

    /**
     * Determines if the game should continue (i.e. game is in check or is
     * 'normal'). If it should not, the user is asked to play again (see above
     * method).
     */
    private void checkGameConditions(boolean nextTurn) {
        IPlayer origPlayer = currentPlayer;
        for (int i = 0; i < 2; i++) {
            int gameLostRetVal = determineGameLost();
            if (gameLostRetVal < 0) {
                state.changeState(new StaleMateState(this,board,king1,king2));
                askUserToPlayAgain("Game over - STALEMATE. You should both go"
                        + " cry in a corner!");
                return;
            } else if (gameLostRetVal > 0) {
                state.changeState(new CheckMateState(this,board,king1,king2,gameLostRetVal));
                askUserToPlayAgain("Game over - CHECKMATE. " + "Player "
                        + gameLostRetVal + " loses and should go"
                        + " cry in a corner!");
                return;
            } else if (isKingInCheck(true)) {
                state.changeState(new CheckState(this,board,king1,king2,currentPlayer.allowPlay()));
                JOptionPane.showMessageDialog(
                        board.getParent(),
                        "Be careful player " + currentPlayer.allowPlay() + ", " +
                                "your king is in check! Your next move must get " +
                                "him out of check or you're screwed.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else if (state.getType() == State.CHECK && state.getPlayerInCheck() == currentPlayer.allowPlay()){
                state.changeState(new NormalState(this,board,king1,king2));
            }
            currentPlayer = new ProxyPlayer( currentPlayer.allowPlay() == 1 ? 2 : 1 );

            // check the next player's conditions as well.
        }
        currentPlayer = origPlayer;
        if(nextTurn)nextTurn();
    }

    /**
     * Determines if the game is lost. Returns 1 or 2 for the losing player, -1
     * for stalemate, or 0 for a still valid game.
     *
     * @return int 1 or 2 for the losing play, -1 for stalemate, or 0 for a
     * still valid game.
     */
    public int determineGameLost() {
        if ((kingService.isChecked(king1) && !playerHasLegalMoves(1)) || (((ChessPanel) board.getParent()).getGraveyard(1).quiereRendirse(1)==0) ) // player 1
        // loss
        {
            return 1;
        }else
        if ((kingService.isChecked(king2) && !playerHasLegalMoves(2)) || (((ChessPanel) board.getParent()).getGraveyard(2).quiereRendirse(2)==0)) // player 2
        // loss
        {
            return 2;
        }
        if ((!kingService.isChecked(king1) && !playerHasLegalMoves(1))
                || (!kingService.isChecked(king2) && !playerHasLegalMoves(2))
                || (board.getAllWhitePieces().size() == 1 &&
                board.getAllBlackPieces().size() == 1)) // stalemate
        {
            return -1;
        }
        return 0; // game is still in play
    }
    // ----------------------------------------------------------

    /**
     * Given a MouseEvent from a user clicking on a square, the appropriate
     * action is determined. Actions include: moving a piece, showing the possi
     * ble moves of a piece, or ending the game after checking game conditions.
     *
     * @param e the mouse event from the listener
     */
    public void determineActionFromSquareClick(MouseEvent e) {
        BoardSquare squareClicked = (BoardSquare) e.getSource();
        ChessGamePiece pieceOnSquare = squareClicked.getPieceOnSquare();
        board.clearColorsOnBoard();
        state.update();
        if ((firstClick)) {
            currentPiece = squareClicked.getPieceOnSquare();
            if (selectedPieceIsValid()) {
                pieceMoveService.showLegalMoves(board,currentPiece);
                squareClicked.setBackground(Color.GREEN);
                firstClick = false;
            } else {
                if (currentPiece != null) {
                    JOptionPane.showMessageDialog(
                            squareClicked,
                            "You tried to pick up the other player's piece! "
                                    + "Get some glasses and pick a valid square.",
                            "Illegal move",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(
                            squareClicked,
                            "You tried to pick up an empty square! "
                                    + "Get some glasses and pick a valid square.",
                            "Illegal move",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            if ((pieceOnSquare == null || !pieceOnSquare.equals(currentPiece))){
                int rowSelect = currentPiece.getRow();
                int colSelect = currentPiece.getColumn();
                boolean moveSuccessful =
                        pieceMoveService.move(
                                board,currentPiece,squareClicked.getRow(), squareClicked.getColumn());
                if (moveSuccessful) {
                    checkGameConditions(true);
                    if(MULTIPLAYER_MODE.equals(((ChessPanel) board.getParent()).getMultiplayerFilter().getModoSelect())){
                        this.movePieceNetwork(rowSelect,colSelect,squareClicked);
                    }
                } else {
                    int row = squareClicked.getRow();
                    int col = squareClicked.getColumn();
                    JOptionPane.showMessageDialog(
                            squareClicked,
                            "The move to row " + (row + 1) + " and column "
                                    + (col + 1)
                                    + " is either not valid or not legal "
                                    + "for this piece. Choose another move location, "
                                    + "and try using your brain this time!",
                            "Invalid move",
                            JOptionPane.ERROR_MESSAGE);
                }
                firstClick = true;
            } else
            // user is just unselecting the current piece
            {
                firstClick = true;

            }
        }
    }

    private Boolean movePiece(ChessGamePiece pieceOnSquare,int row, int col ) {
        if (pieceOnSquare == null || (pieceOnSquare.getColumn() != col || pieceOnSquare.getRow() != col)){
            int rowSelect = pieceOnSquare.getRow();
            int colSelect = pieceOnSquare.getColumn();
            boolean moveSuccessful = pieceMoveService.move(
                    board, pieceOnSquare, row, col);
            if (moveSuccessful) {
                checkGameConditions(true);
                board.clearCell(rowSelect,colSelect);
                board.repaint();
                board.revalidate();
            }
        }
        return false;
    }

    public void movePieceNetwork(int row, int col, BoardSquare boardSquare){
        if(boardSquare == null){
            return;
        }
        if (printWriter != null) {
            printWriter.println(col + "," + row +
                    "," +boardSquare.getColumn() + "," + boardSquare.getRow());
        }
    }

    private void receiveMove(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String moveStr = scanner.nextLine();
            System.out.println("Movimiento recibido: " + moveStr);
            String[] moveStrArr = moveStr.split(",");
            Integer fromCol = Integer.parseInt(moveStrArr[0]);
            Integer fromRow = Integer.parseInt(moveStrArr[1]);
            Integer toCol = Integer.parseInt(moveStrArr[2]);
            Integer toRow = Integer.parseInt(moveStrArr[3]);

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    BoardSquare boardSquare = board.getCell(fromRow,fromCol);
                    movePiece(boardSquare.getPieceOnSquare(),toRow,toCol);
                }
            });
        }
    }

    public void runSocketServer() {
        Executors.newFixedThreadPool(1).execute(new Runnable() {
            @Override
            public void run() {
                try {
                    if(listener == null || listener.isClosed()){
                        listener = new ServerSocket(PORT);
                        System.out.println("Servidor escuchando puerto: " + PORT);
                        socket = listener.accept();
                        printWriter = new PrintWriter(socket.getOutputStream(), true);
                        Scanner scanner = new Scanner(socket.getInputStream());
                        receiveMove(scanner);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void runSocketClient() {
        try {
            if(socket!= null && socket.isConnected()){
                return;
            }

            socket = new Socket(SOCKET_SERVER_ADDR, PORT);
            System.out.println("Cliente conectandose a Puerto: " + PORT);
            Scanner scanner = new Scanner(socket.getInputStream());
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            Executors.newFixedThreadPool(1).execute(new Runnable() {
                @Override
                public void run() {
                    receiveMove(scanner);
                }
            });
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


    public ChessGamePiece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(ChessGamePiece currentPiece) {
        this.currentPiece = currentPiece;
    }

    public boolean isFirstClick() {
        return firstClick;
    }

    public void setFirstClick(boolean firstClick) {
        this.firstClick = firstClick;
    }

    public void setCurrentPlayer(IPlayer currentPlayer) {
      this.currentPlayer = currentPlayer;
    }

    public ChessGameBoard getBoard() {
        return board;
    }

    public void setBoard(ChessGameBoard board) {
        this.board = board;
    }

    public King getKing1() {
        return king1;
    }

    public void setKing1(King king1) {
        this.king1 = king1;
    }

    public King getKing2() {
        return king2;
    }

    public void setKing2(King king2) {
        this.king2 = king2;
    }
}
