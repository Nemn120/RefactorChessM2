package business.service.moves.pieces;

import business.service.moves.cardinal.CalculateCardinalMove;
import business.service.moves.cardinal.CalculateMovesFactory;
import business.service.moves.cardinal.abstractFactoryCardinal.*;
import util.CardinalPoint;
import util.ColorOfPiece;

import java.util.List;

public class BishopMove implements ICreateMove{

    @Override
    public List<CalculateCardinalMove> createMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        Object diagonal = InvokeMoveCardinal.createMoveCardinal(new CalculateCardinalDiagonalFactory());
        return ((CalculateMoveDiagonal)diagonal).getInstance(pieceRow, pieceColumn, color,
                CardinalPoint.NORTHEAST,
                CardinalPoint.NORTHWEST,
                CardinalPoint.SOUTHEAST,
                CardinalPoint.SOUTHWEST);
    }
}
