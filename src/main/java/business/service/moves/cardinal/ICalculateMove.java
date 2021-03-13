package business.service.moves.cardinal;

import java.util.ArrayList;

import gui.board.ChessGameBoard;

public interface ICalculateMove {

	ArrayList<String> invoke(ChessGameBoard board, int numMoves);
}
