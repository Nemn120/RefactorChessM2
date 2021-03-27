package business.service.moves.cardinal.abstractFactoryCardinal;

import java.util.ArrayList;

public class InvokeMoveCardinal {

    public static Object createMoveCardinal(ICalculateCardinalFactory typeMove, String typeDirection) {
        switch (typeDirection) {
            case "cruz": {
                CalculateMoveCruz cruz = (CalculateMoveCruz) typeMove.createMoveCardinal();
                return cruz;
            }
            case "diagonal": {
                CalculateMoveDiagonal diagonal = (CalculateMoveDiagonal) typeMove.createMoveCardinal();
                return diagonal;
            }
        }
        return null;
    }
}
