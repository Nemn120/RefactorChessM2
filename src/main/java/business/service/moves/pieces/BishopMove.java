package business.service.moves.pieces;

import business.service.moves.cardinal.CalculateCardinalMove;
import business.service.moves.cardinal.CalculateMovesFactory;
import business.service.moves.cardinal.abstractFactoryCardinal.CalculateCardinalCruzFactory;
import business.service.moves.cardinal.abstractFactoryCardinal.CalculateMoveCruz;
import business.service.moves.cardinal.abstractFactoryCardinal.ICalculateCardinalFactory;
import business.service.moves.cardinal.abstractFactoryCardinal.InvokeMoveCardinal;
import util.CardinalPoint;
import util.ColorOfPiece;

import java.util.List;

public class BishopMove implements ICreateMove{

    @Override
    public List<CalculateCardinalMove> createMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        Object cruz = InvokeMoveCardinal.createMoveCardinal(new CalculateCardinalCruzFactory(), "cruz");
        return ((CalculateMoveCruz)cruz).getInstance(pieceRow, pieceColumn, color,
                CardinalPoint.NORTHEAST,
                CardinalPoint.NORTHWEST,
                CardinalPoint.SOUTHEAST,
                CardinalPoint.SOUTHWEST);
    }
}
