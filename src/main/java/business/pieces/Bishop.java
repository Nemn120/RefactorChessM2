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

public class Bishop extends ChessGamePiece {

    public Bishop(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
        pieceMove = new PieceMove((List<CalculateCardinalMove>)FacadeMoveByPiece.movePiece(TypeOfMove.TYPE_MOVE_BISHOP,row,col,new ColorOfPiece(color)));
        possibleMoves = pieceMove.calculateCardinalMoves(board,8);
    }

    public Bishop(ChessGamePiece piece, ChessGameBoard board){
        super(piece,board);
    }

    @Override
    public ChessGamePiece clone(ChessGameBoard board) {
        return new Bishop(this,board);
    }

    public void calculatePossibleMoves(ChessGameBoard board){
        pieceMove = new PieceMove((List<CalculateCardinalMove>)FacadeMoveByPiece.movePiece(TypeOfMove.TYPE_MOVE_BISHOP,pieceRow,pieceColumn,colorOfPiece));
        possibleMoves = pieceMove.calculateCardinalMoves(board,8);
    }

    @Override
    public ImageIcon createImageByPieceType(){
        return new ImageIcon(
                getClass().getResource(resourceOfPiece.resourceByType("Bishop"))
        );
    }

    @Override
    public boolean isNull(){
        return false;
    }

    @Override
    public void aceptar(Visitor v) {
        v.visitBishop(this);
    }

}
