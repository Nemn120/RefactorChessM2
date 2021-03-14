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
 * Class to represent the Bishop piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Bishop extends ChessGamePiece {

    public Bishop(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
        ICreateMove createMoveBishop = null;
        createMoveBishop = CreateMoveFactory.getInstance(TypeOfMove.TYPE_MOVE_BISHSPO);
        pieceMove = new PieceMove((List<CalculateCardinalMove>) createMoveBishop.createMove(row,col,new ColorOfPiece(color)));
        possibleMoves = pieceMove.calculateCardinalMoves(board,8);
    }

    public void calculatePossibleMoves(ChessGameBoard board){
        ICreateMove createMoveBishop = null;
        createMoveBishop = CreateMoveFactory.getInstance(TypeOfMove.TYPE_MOVE_BISHSPO);
        pieceMove = new PieceMove((List<CalculateCardinalMove>) createMoveBishop.createMove(pieceRow,pieceColumn,colorOfPiece));
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
                getClass().getResource(resourceOfPiece.resourceByType("Bishop"))
        );
    }


}
