package business.service.moves.cardinal.abstractFactoryCardinal;

import business.service.moves.cardinal.CalculateCardinalMove;
import business.service.moves.cardinal.impl.*;

import util.CardinalPoint;
import util.ColorOfPiece;

import java.util.ArrayList;
import java.util.List;

public class CalculateMoveCruz extends CreateMoveCardinal{

    @Override
    public List<CalculateCardinalMove> getInstance(int pieceRow, int pieceColumn, ColorOfPiece color,String ... cardinalPoints) {
        List<CalculateCardinalMove> moves = new ArrayList<>();
        for(int i=0; i<cardinalPoints.length; i++) {
            switch (cardinalPoints[i]) {
                case CardinalPoint.SOUTH: {
                    moves.add(new CalculateSouthMoves(pieceRow,pieceColumn,color));break;
                }
                case CardinalPoint.NORTH: {
                    moves.add(new CalculateNorthMoves(pieceRow,pieceColumn,color));break;
                }
                case CardinalPoint.EAST: {
                    moves.add(new CalculateEastMoves(pieceRow,pieceColumn,color));break;
                }
                case CardinalPoint.WEST: {
                    moves.add(new CalculateWestMoves(pieceRow,pieceColumn,color));break;
                }
            }
        }
        return moves;
    }
}
