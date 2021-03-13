package business.service.moves;

import business.pieces.ChessGamePiece;
import gui.board.ChessGameBoard;

public interface IPieceMoveService {

    boolean move(ChessGameBoard board, ChessGamePiece piece, int row, int col);

    boolean canMove(ChessGameBoard board, ChessGamePiece piece, int row, int col);

    boolean testMoveForKingSafety(ChessGameBoard board, ChessGamePiece piece, int row, int col);

    void showLegalMoves(ChessGameBoard board, ChessGamePiece piece);

    boolean hasLegalMoves(ChessGameBoard board, ChessGamePiece piece);

}


