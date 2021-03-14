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

public class Bishop extends ChessGamePiece {

    public Bishop(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
        ICreateMove createMoveBishop = null;
        createMoveBishop = CreateMoveFactory.getInstance(TypeOfMove.TYPE_MOVE_BISHSPO);
        pieceMove = new PieceMove((List<CalculateCardinalMove>) createMoveBishop.createMove(row,col,new ColorOfPiece(color)));
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
        ICreateMove createMoveBishop = null;
        createMoveBishop = CreateMoveFactory.getInstance(TypeOfMove.TYPE_MOVE_BISHSPO);
        pieceMove = new PieceMove((List<CalculateCardinalMove>) createMoveBishop.createMove(pieceRow,pieceColumn,colorOfPiece));
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

}
