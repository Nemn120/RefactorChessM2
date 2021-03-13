package business.service.king;

import business.service.moves.IPieceMoveService;
import business.pieces.ChessGamePiece;
import gui.board.ChessGameBoard;
import util.ColorOfPiece;

import java.util.ArrayList;

public class KingService implements IKingService{

    private ChessGameBoard board;
    private IPieceMoveService pieceMoveService;

    public KingService(ChessGameBoard board,IPieceMoveService pieceMoveService) {
        this.board = board;
        this.pieceMoveService = pieceMoveService;
    }

    /**
     * Gets a list of GamePieces that can currently attack this game piece.
     *
     * @return ArrayList<GamePiece> the list of attackers
     */
    private ArrayList<ChessGamePiece> getCurrentAttackers(ChessGamePiece piece) {
        ArrayList<ChessGamePiece> attackers = new ArrayList<ChessGamePiece>();
        int enemyColor =
                (piece.getColorOfPiece().getColor() == ColorOfPiece.BLACK)
                        ? ColorOfPiece.WHITE
                        : ColorOfPiece.BLACK;
        piece.calculatePossibleMoves(board);
        for (int i = 0; i < board.getCells().length; i++) {
            for (int j = 0; j < board.getCells()[0].length; j++) {
                ChessGamePiece currPiece =
                        board.getCell(i, j).getPieceOnSquare();
                if (currPiece != null
                        && currPiece.getColorOfPiece().getColor() == enemyColor) {
                    piece.calculatePossibleMoves(board);
                    if (pieceMoveService.canMove(board,currPiece,piece.getRow(), piece.getColumn())) {
                        attackers.add(currPiece);
                    }
                }
            }
        }
        return attackers;
    }

    /**
     * Determines if this King is checked.
     *
     * @return true if checked, false if not checked
     */
    @Override
    public boolean isChecked(ChessGamePiece piece){
        return this.getCurrentAttackers(piece).size() > 0;
    }
}
