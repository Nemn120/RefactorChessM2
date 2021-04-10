package business.service.moves.pieces;

import business.service.moves.cardinal.CalculateCardinalMove;
import gui.board.ChessGameBoard;
import util.TypeOfMove;

import java.util.ArrayList;
import java.util.List;

public class PieceMove {

    List<CalculateCardinalMove> calculateCardinalMoves;

    public PieceMove(List<CalculateCardinalMove> calculateCardinalMoves) {
        this.calculateCardinalMoves = calculateCardinalMoves;
    }

    public List<String> calculateCardinalMoves(ChessGameBoard board, int numMoves){
        List<String> allMoves = new ArrayList<>();
        calculateCardinalMoves.forEach(x -> {
            allMoves.addAll(this.calculateCardinalMove(x,board,numMoves));
        });
        return allMoves;
    }

    public List<String> calculateCardinalMove(CalculateCardinalMove cardinalMove, ChessGameBoard board, int numMoves){
        return cardinalMove.invoke(board,numMoves);
    }
}
