package business.pieces.factory;

import business.piecenull.PieceNull;
import business.pieces.*;
import gui.board.ChessGameBoard;
import util.IteratorPattern.AgregadoConcreto;
import util.IteratorPattern.Iterador;

public class PieceFactory {

    public static ChessGamePiece createPiece(String piece,ChessGameBoard board,int row,int col, int color){
        AgregadoConcreto agregado = new AgregadoConcreto();
        Iterador iterador = agregado.getIterador();
        while(iterador.hasNext() == true){
            if(piece == "Bishop"){
                return new Bishop(board,row,col,color);
            }
            else if(piece == "King"){
                return new King(board,row,col,color);
            }
            else if(piece == "Knight"){
                return new Knight(board,row,col,color);
            }
            else if(piece == "Pawn"){
                return new Pawn(board,row,col,color);
            }
            else if(piece == "Queen") {
                return new Queen(board, row, col, color);
            }
            else if(piece == "Rook") {
                return new Rook(board, row, col, color);
            }
            iterador.next();
        }
        return null;
    }

}
