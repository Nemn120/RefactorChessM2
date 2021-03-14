package business.pieces;

import business.service.moves.pieces.PawnMove;
import gui.board.ChessGameBoard;

import javax.swing.*;

/**
 * Represents a Pawn game piece. Unique in that it can move two locations on its
 * first turn and therefore requires a new 'notMoved' variable to keep track of
 * its turns.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Pawn extends ChessGamePiece {

    private boolean notMoved;
    private PawnMove pawnMove;

    public Pawn(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color, true);
        notMoved = true;
        pawnMove = new PawnMove();
    }
    public Pawn(ChessGamePiece piece, ChessGameBoard board){
        super(piece,board);
    }

    @Override
    public boolean isNull(){
        return false;
    }

    /**
     * Calculates the possible moves for this piece. These are ALL the possible
     * moves, including illegal (but at the same time valid) moves.
     *
     * @param board the game board to calculate moves on
     * @return ArrayList<String> the moves
     */
    @Override
    public ChessGamePiece clone(ChessGameBoard board) {
        return new Pawn(this,board);
    }

    public void calculatePossibleMoves(ChessGameBoard board) {
        possibleMoves = pawnMove.calculatePossibleMoves(board,pieceRow,pieceColumn,colorOfPiece.getColor(),isNotMoved());
    }

    public boolean isNotMoved() {
        return notMoved;
    }

    public void setNotMoved(boolean notMoved) {
        this.notMoved = notMoved;
    }

    @Override
    public ImageIcon createImageByPieceType(){
        return new ImageIcon(
                getClass().getResource(resourceOfPiece.resourceByType("Pawn"))
        );
    }
}
