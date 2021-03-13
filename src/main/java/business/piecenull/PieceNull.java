package business.piecenull;

import business.pieces.ChessGamePiece;
import gui.board.ChessGameBoard;

import javax.swing.*;

/**
 * Class to represent the Bishop piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class PieceNull extends ChessGamePiece {

    public PieceNull() {
    }

    @Override
    public boolean isNull(){
        return true;
    }

    @Override
    public ChessGamePiece clone(ChessGameBoard board) {
        return null;
    }

    @Override
    public void calculatePossibleMoves(ChessGameBoard board) {
        System.out.println("Este objeto es nulo");
    }

    @Override
    public ImageIcon createImageByPieceType() {
        System.out.println("Este objeto es nulo");
        return null;
    }


}
