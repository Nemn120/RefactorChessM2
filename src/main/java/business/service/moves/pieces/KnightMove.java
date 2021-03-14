package business.service.moves.pieces;

import business.service.moves.cardinal.ICalculateCardinalKnightMove;
import business.service.moves.cardinal.impl.CalculateKnightNorthMoves;
import business.service.moves.cardinal.impl.CalculateKnightSouthMoves;
import gui.board.ChessGameBoard;
import util.ColorOfPiece;
import util.IsOnScreen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightMove implements ICreateMove {

    List<ICalculateCardinalKnightMove> calculateCardinalKnightMoves;

    public KnightMove(List<ICalculateCardinalKnightMove> calculateCardinalKnightMoves) {
        this.calculateCardinalKnightMoves = calculateCardinalKnightMoves;
    }

    public KnightMove() { };

    public List<String> calculatePossibleMoves(ChessGameBoard board, int row, int column) {
        ArrayList<String> moves = new ArrayList<>();
        if (IsOnScreen.invoke(row, column)) {
            calculateCardinalKnightMoves.forEach(cardinalKnightMove -> {
                moves.addAll(cardinalKnightMove.invoke(board));
            });
        }
        return moves;
    }

    @Override
    public List<?> createMove(int pieceRow, int pieceColumn, ColorOfPiece color) {
        return Arrays.asList(new CalculateKnightNorthMoves(pieceRow,pieceColumn,color),
                new CalculateKnightSouthMoves(pieceRow,pieceColumn,color));
    }
}
