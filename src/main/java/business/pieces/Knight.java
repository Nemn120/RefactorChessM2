package business.pieces;

import business.service.moves.cardinal.ICalculateCardinalKnightMove;
import business.service.moves.pieces.*;
import business.visitor.Visitor;
import util.ColorOfPiece;
import gui.board.ChessGameBoard;
import util.TypeOfMove;

import javax.swing.*;
import java.util.List;

public class Knight extends ChessGamePiece {

    private KnightMove knightMove;

    public Knight(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
        knightMove = new KnightMove((List<ICalculateCardinalKnightMove>)FacadeMoveByPiece.movePiece(TypeOfMove.TYPE_MOVE_KNIGHT,row,col,new ColorOfPiece(color)));
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
        knightMove = new KnightMove((List<ICalculateCardinalKnightMove>)FacadeMoveByPiece.movePiece(TypeOfMove.TYPE_MOVE_KNIGHT,pieceRow,pieceColumn,colorOfPiece));
        possibleMoves = knightMove.calculatePossibleMoves(board,pieceRow,pieceColumn);
    }


    /**
     * Creates an icon for this piece depending on the piece's color.
     *
     * @return ImageIcon the ImageIcon representation of this piece.
     */
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

    @Override
    public void aceptar(Visitor v) {
        v.visitKnight(this);
    }
}