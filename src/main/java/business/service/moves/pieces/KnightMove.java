package business.service.moves.pieces;

import business.service.moves.cardinal.ICalculateCardinalKnightMove;
import gui.board.ChessGameBoard;
import util.IsOnScreen;

import java.util.ArrayList;
import java.util.List;

public class KnightMove {

    List<ICalculateCardinalKnightMove> calculateCardinalKnightMoves;

    public KnightMove(List<ICalculateCardinalKnightMove> calculateCardinalKnightMoves) {
        this.calculateCardinalKnightMoves = calculateCardinalKnightMoves;
    }

    public List<String> calculatePossibleMoves(ChessGameBoard board, int row, int column) {
        ArrayList<String> moves = new ArrayList<>();
        if (IsOnScreen.invoke(row, column)) {
            calculateCardinalKnightMoves.forEach(cardinalKnightMove -> {
                moves.addAll(cardinalKnightMove.invoke(board));
            });
        }
        return moves;
    }

}
