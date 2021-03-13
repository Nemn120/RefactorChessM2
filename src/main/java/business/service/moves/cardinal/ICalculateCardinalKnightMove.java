package business.service.moves.cardinal;

import gui.board.ChessGameBoard;

import java.util.ArrayList;

public interface ICalculateCardinalKnightMove {

    ArrayList<String> invoke(ChessGameBoard board);

}
