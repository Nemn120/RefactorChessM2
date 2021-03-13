package business.pieces;

import business.service.moves.pieces.CreateMoveService;
import business.service.moves.pieces.PieceMove;
import gui.board.ChessGameBoard;
import util.ColorOfPiece;

import javax.swing.*;

public class Queen extends ChessGamePiece {

    public Queen(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
        pieceMove = new PieceMove(CreateMoveService.kingOrQeenMove(row,col,new ColorOfPiece(color)));
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
        pieceMove = new PieceMove(CreateMoveService.kingOrQeenMove(pieceRow,pieceColumn,colorOfPiece));
        possibleMoves = pieceMove.calculateCardinalMoves(board,8);
    }

    @Override
    public ImageIcon createImageByPieceType(){
        return new ImageIcon(
                getClass().getResource(resourceOfPiece.resourceByType("Queen"))
        );
    }
}
