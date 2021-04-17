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

public class Rook extends ChessGamePiece {

    public Rook(ChessGamePiece piece, ChessGameBoard board){
        super(piece,board);
    }

    @Override
    public ChessGamePiece clone(ChessGameBoard board) {
        return new Rook(this,board);
    }

    @Override
    public boolean isNull(){
        return false;
    }

    public Rook(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
        pieceMove = new PieceMove((List<CalculateCardinalMove>)FacadeMoveByPiece.movePiece(TypeOfMove.TYPE_MOVE_ROOK,row,col,new ColorOfPiece(color)));
        possibleMoves = pieceMove.calculateCardinalMoves(board,8);
    }

    @Override
    public void calculatePossibleMoves(ChessGameBoard board) {
        pieceMove = new PieceMove((List<CalculateCardinalMove>)FacadeMoveByPiece.movePiece(TypeOfMove.TYPE_MOVE_ROOK,pieceRow,pieceColumn,colorOfPiece));
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

    @Override
    public void aceptar(Visitor v) {
        v.visitRook(this);
    }
}