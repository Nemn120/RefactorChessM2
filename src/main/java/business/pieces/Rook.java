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
 * Represents a Rook game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Rook extends ChessGamePiece {

    /**
     * Create a new Rook object.
     *
     * @param board the board to create the rook on
     * @param row   the row to create the rook on
     * @param col   the column to create the rook on
     * @param color either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Rook(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
        ICreateMove createMoveRook = null;
        createMoveRook = CreateMoveFactory.getInstance(TypeOfMove.TYPE_MOVE_ROOK);
        pieceMove = new PieceMove((List<CalculateCardinalMove>) createMoveRook.createMove(row,col,new ColorOfPiece(color)));
        possibleMoves = pieceMove.calculateCardinalMoves(board,8);
    }

    @Override
    public void calculatePossibleMoves(ChessGameBoard board) {
        ICreateMove createMoveRook = null;
        createMoveRook = CreateMoveFactory.getInstance(TypeOfMove.TYPE_MOVE_ROOK);
        pieceMove = new PieceMove((List<CalculateCardinalMove>) createMoveRook.createMove(pieceRow,pieceColumn,colorOfPiece));
        possibleMoves = pieceMove.calculateCardinalMoves(board,8);
    }

    /**
     * Creates an icon for this piece depending on the piece's color.
     *
     * @return ImageIcon the ImageIcon representation of this piece.
     */
    @Override
    public ImageIcon createImageByPieceType(){
        return new ImageIcon(
                getClass().getResource(resourceOfPiece.resourceByType("Rook"))
        );
    }
}