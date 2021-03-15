package business.service.moves.cardinal;

import java.util.ArrayList;
import java.util.List;

import business.service.moves.cardinal.impl.CalculateEastMoves;
import business.service.moves.cardinal.impl.CalculateNorthEastMoves;
import business.service.moves.cardinal.impl.CalculateNorthMoves;
import business.service.moves.cardinal.impl.CalculateNorthWestMoves;
import business.service.moves.cardinal.impl.CalculateSouthEastMoves;
import business.service.moves.cardinal.impl.CalculateSouthMoves;
import business.service.moves.cardinal.impl.CalculateSouthWestMoves;
import business.service.moves.cardinal.impl.CalculateWestMoves;
import util.CardinalPoint;
import util.ColorOfPiece;

public class CalculateMovesFactory {

    public static List<CalculateCardinalMove> getInstance(int pieceRow, int pieceColumn, ColorOfPiece color,String ... cardinalPoints) {
        List<CalculateCardinalMove> moves = new ArrayList<CalculateCardinalMove>();
        for (int i=0 ; i < cardinalPoints.length ; i++) {
            switch (cardinalPoints[i]) {
                case CardinalPoint.NORTH: moves.add(new CalculateNorthMoves(pieceRow,pieceColumn,color));break;
                case CardinalPoint.SOUTH: moves.add(new CalculateSouthMoves(pieceRow,pieceColumn,color));break;
                case CardinalPoint.EAST: moves.add(new CalculateEastMoves(pieceRow,pieceColumn,color));break;
                case CardinalPoint.WEST: moves.add(new CalculateWestMoves(pieceRow,pieceColumn,color));break;
                case CardinalPoint.NORTHEAST: moves.add(new CalculateNorthEastMoves(pieceRow,pieceColumn,color));break;
                case CardinalPoint.NORTHWEST: moves.add(new CalculateNorthWestMoves(pieceRow,pieceColumn,color));break;
                case CardinalPoint.SOUTHEAST: moves.add(new CalculateSouthEastMoves(pieceRow,pieceColumn,color));break;
                case CardinalPoint.SOUTHWEST: moves.add(new CalculateSouthWestMoves(pieceRow,pieceColumn,color));break;
            }
        }
        return moves;
    }
}
