package business.pieces;

import business.service.moves.cardinal.CalculateCardinalMove;
import business.service.moves.pieces.CreateMoveFactory;
import business.service.moves.pieces.ICreateMove;
import business.service.moves.pieces.PieceMove;
import gui.board.ChessGameBoard;
import util.ColorOfPiece;
import util.TypeOfMove;

import javax.swing.*;
import java.util.List;

/**
 * Represents a King game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class King extends ChessGamePiece{

    /**
     * Create a new King object.
     *
     * @param board
     *            the board to create the king on
     * @param row
     *            the row to create the king on
     * @param col
     *            the column to create the king on
     * @param color
     *            either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public King( ChessGameBoard board, int row, int col, int color ){
        super( board, row, col, color, false );
        ICreateMove createMoveKing = null;
        createMoveKing = CreateMoveFactory.getInstance(TypeOfMove.TYPE_MOVE_KING_OR_QUEEN);
        pieceMove = new PieceMove((List<CalculateCardinalMove>) createMoveKing.createMove(row,col,new ColorOfPiece(color)));
        if (!this.skipMoveGeneration) {
            possibleMoves = pieceMove.calculateCardinalMoves(board,1);
        }
    }

    public King(ChessGamePiece piece, ChessGameBoard board){
        super(piece,board);
    }

    @Override
    public ChessGamePiece clone(ChessGameBoard board) {
        return new King(this,board);
    }

    @Override
    public void calculatePossibleMoves(ChessGameBoard board) {
        ICreateMove createMoveKing = null;
        createMoveKing = CreateMoveFactory.getInstance(TypeOfMove.TYPE_MOVE_KING_OR_QUEEN);
        pieceMove = new PieceMove((List<CalculateCardinalMove>) createMoveKing.createMove(pieceRow,pieceColumn,colorOfPiece));
        possibleMoves = pieceMove.calculateCardinalMoves(board,1);
    }

    /**
     * Creates an icon for this piece depending on the piece's color.
     *
     * @return ImageIcon the ImageIcon representation of this piece.
     */
    @Override
    public ImageIcon createImageByPieceType(){
        return new ImageIcon(
                getClass().getResource(resourceOfPiece.resourceByType("King"))
        );
    }

    @Override
    public boolean isNull(){
        return false;
    }
}
