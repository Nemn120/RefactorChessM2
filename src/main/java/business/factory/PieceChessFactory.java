package business.factory;

import business.pieces.*;
import business.piecenull.PieceNull;
import gui.board.ChessGameBoard;
import util.IteratorPattern.AgregadoConcreto;
import util.IteratorPattern.Iterador;

public class PieceChessFactory {
    public static ChessGamePiece createChessPiece(String PieceType, ChessGameBoard board,
                                                  int row,
                                                  int col,
                                                  int color){
        ChessGamePiece piece = null;
        if("Bishop".equalsIgnoreCase(PieceType)){
            piece = new Bishop(board, row, col, color);
        }
        else if("King".equalsIgnoreCase(PieceType)){
            piece = new King(board, row, col, color);
        }
        else if("Knight".equalsIgnoreCase(PieceType)){
            piece = new Knight(board, row, col, color);
        }
        else if("Pawn".equalsIgnoreCase(PieceType)){
            piece = new Pawn(board, row, col, color);
        }
        else if("Queen".equalsIgnoreCase(PieceType)){
            piece = new Queen(board, row, col, color);
        }
        else if("Rook".equalsIgnoreCase(PieceType)){
            piece = new Rook(board, row, col, color);
        }
        else{
            piece = new PieceNull();
        }
        return piece;
    }

}
