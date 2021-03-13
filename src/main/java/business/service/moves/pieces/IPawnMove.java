package business.service.moves.pieces;

import gui.board.ChessGameBoard;

import java.util.ArrayList;

public interface IPawnMove {

    ArrayList<String> calculatePossibleMoves(ChessGameBoard board, int row, int column, int color, boolean isNotMoved);
}