package business.pieces;

import business.service.moves.pieces.CreateMoveService;
import business.service.moves.pieces.KnightMove;
import util.ColorOfPiece;
import gui.board.ChessGameBoard;

import javax.swing.*;

public class Knight extends ChessGamePiece {

    private KnightMove knightMove;

    public Knight(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
        knightMove = new KnightMove(CreateMoveService.knightMove(row,col,new ColorOfPiece(color)));
        possibleMoves = knightMove.calculatePossibleMoves(board,row,col);
    }

    public Knight(ChessGamePiece piece, ChessGameBoard board){
        super(piece,board);
    }

    @Override
    public ChessGamePiece clone(ChessGameBoard board) {
        return new Knight(this,board);
    }

    @Override
    public void calculatePossibleMoves(ChessGameBoard board) {
        knightMove = new KnightMove(CreateMoveService.knightMove(pieceRow,pieceColumn,colorOfPiece));
        possibleMoves = knightMove.calculatePossibleMoves(board,pieceRow,pieceColumn);
    }

    @Override
    public ImageIcon createImageByPieceType(){
        return new ImageIcon(
                getClass().getResource(resourceOfPiece.resourceByType("Knight"))
        );
    }

    @Override
    public boolean isNull(){
        return false;
    }
}