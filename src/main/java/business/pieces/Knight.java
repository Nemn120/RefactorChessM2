package business.pieces;

import business.service.moves.pieces.CreateMoveService;
import business.service.moves.pieces.KnightMove;
import util.ColorOfPiece;
import gui.board.ChessGameBoard;

import javax.swing.*;

/**
 * Represents a Knight game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Knight extends ChessGamePiece {

    private KnightMove knightMove;
    /**
     * Knight constructor for gamePiece
     *
     * @param row   the row to create the knight on
     * @param col   the column to create the knight on
     * @param board the board to create the piece on
     * @param color either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Knight(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
        knightMove = new KnightMove(CreateMoveService.knightMove(row,col,new ColorOfPiece(color)));
        possibleMoves = knightMove.calculatePossibleMoves(board,row,col);
    }

    @Override
    public void calculatePossibleMoves(ChessGameBoard board) {
        knightMove = new KnightMove(CreateMoveService.knightMove(pieceRow,pieceColumn,colorOfPiece));
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
}