package business.service.moves.cardinal.abstractFactoryCardinal;

import business.service.moves.cardinal.CalculateCardinalMove;
import business.service.moves.cardinal.impl.*;
import util.CardinalPoint;
import util.ColorOfPiece;

import java.util.ArrayList;
import java.util.List;

public class CalculateMoveDiagonal extends CreateMoveCardinal{

    @Override
    public List<CalculateCardinalMove> getInstance(int pieceRow, int pieceColumn, ColorOfPiece color, String... cardinalPoints) {
        List<CalculateCardinalMove> moves = new ArrayList<CalculateCardinalMove>();
        for(int i=0; i<cardinalPoints.length; i++) {
            switch (cardinalPoints[i]) {
                case CardinalPoint.SOUTHEAST: {
                    moves.add(new CalculateSouthEastMoves(pieceRow,pieceColumn,color));break;
                }
                case CardinalPoint.SOUTHWEST: {
                    moves.add(new CalculateSouthWestMoves(pieceRow,pieceColumn,color));break;
                }
                case CardinalPoint.NORTHEAST: {
                    moves.add(new CalculateNorthEastMoves(pieceRow,pieceColumn,color));break;
                }
                case CardinalPoint.NORTHWEST: {
                    moves.add(new CalculateNorthWestMoves(pieceRow,pieceColumn,color));break;
                }
            }
        }
        return moves;
    }
}
