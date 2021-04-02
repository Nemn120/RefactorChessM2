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
        AgregadoConcreto agregado = new AgregadoConcreto();
        Iterador iterador = agregado.getIterador();
        while(iterador.hasNext() == true){
            if(iterador.actual() == "Bishop"){
                piece = new Bishop(board, row, col, color);
            }
            else if(iterador.actual() == "King"){
                piece = new King(board, row, col, color);
            }
            else if(iterador.actual() == "Knight"){
                piece = new Knight(board, row, col, color);
            }
            else if(iterador.actual() == "Pawn"){
                piece = new Pawn(board, row, col, color);
            }
            else if(iterador.actual() == "Queen"){
                piece = new Queen(board, row, col, color);
            }
            else if(iterador.actual() == "Rook"){
                piece = new Rook(board, row, col, color);
            }
            else{
                piece = new PieceNull();
            }
        }
        return piece;
    }

}
