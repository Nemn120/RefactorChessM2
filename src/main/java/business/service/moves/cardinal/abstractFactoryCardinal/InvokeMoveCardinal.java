package business.service.moves.cardinal.abstractFactoryCardinal;

import java.util.ArrayList;

public class InvokeMoveCardinal {

    public static Object createMoveCardinal(ICalculateCardinalFactory typeMove) {
        if (typeMove instanceof  CalculateCardinalCruzFactory) {
            CalculateMoveCruz cruz = (CalculateMoveCruz) typeMove.createMoveCardinal();
            return cruz;
        } else if (typeMove instanceof CalculateCardinalDiagonalFactory) {
            CalculateMoveDiagonal diagonal = (CalculateMoveDiagonal) typeMove.createMoveCardinal();
            return diagonal;
        }
        return null;
    }
}
