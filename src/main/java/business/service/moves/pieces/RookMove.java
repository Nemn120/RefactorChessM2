package business.service.moves.pieces;

import business.service.moves.cardinal.CalculateCardinalMove;
import business.service.moves.cardinal.CalculateMovesFactory;
import util.CardinalPoint;
import util.ColorOfPiece;

import java.util.List;

public class RookMove implements ICreateMove{

    @Override
    public List<CalculateCardinalMove> createMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        return CalculateMovesFactory.getInstance(pieceRow, pieceColumn, color,
            CardinalPoint.SOUTH,
            CardinalPoint.NORTH,
            CardinalPoint.EAST,
            CardinalPoint.WEST);
    }
}
