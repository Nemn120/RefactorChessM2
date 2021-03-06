package business.pieces;

import business.service.moves.cardinal.CalculateCardinalMove;
import business.service.moves.pieces.CreateMoveFactory;
import business.service.moves.pieces.FacadeMoveByPiece;
import business.service.moves.pieces.ICreateMove;
import business.service.moves.pieces.PieceMove;
import business.visitor.Visitor;
import gui.board.ChessGameBoard;
import util.ColorOfPiece;
import util.TypeOfMove;

import javax.swing.*;
import java.util.List;

/**
 * Represents a Queen game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Queen extends ChessGamePiece {


    /**
     * Create a new Queen object.
     *
     * @param board the board the queen is on
     * @param row   the row location of the queen
     * @param col   the column location of the queen
     * @param color either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Queen(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
        pieceMove = new PieceMove((List<CalculateCardinalMove>)FacadeMoveByPiece.movePiece(TypeOfMove.TYPE_MOVE_KING_OR_QUEEN,row,col,new ColorOfPiece(color)));
        possibleMoves = pieceMove.calculateCardinalMoves(board,8);
    }

    public Queen(ChessGamePiece piece, ChessGameBoard board){
        super(piece,board);
    }

    @Override
    public boolean isNull(){
        return false;
    }

    @Override
    public ChessGamePiece clone(ChessGameBoard board) {
        return new Queen(this,board);
    }

    @Override
    public void calculatePossibleMoves(ChessGameBoard board) {
        pieceMove = new PieceMove((List<CalculateCardinalMove>)FacadeMoveByPiece.movePiece(TypeOfMove.TYPE_MOVE_KING_OR_QUEEN,pieceRow,pieceColumn,colorOfPiece));
        possibleMoves = pieceMove.calculateCardinalMoves(board,8);
    }

    @Override
    public ImageIcon createImageByPieceType(){
        return new ImageIcon(
                getClass().getResource(resourceOfPiece.resourceByType("Queen"))
        );
    }

    @Override
    public void aceptar(Visitor v) {
        v.visitQueen(this);
    }
}
