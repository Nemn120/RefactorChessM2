package business.service.moves.pieces;

import util.TypeOfMove;

public class CreateMoveFactory {

    public static ICreateMove getInstance(String typeMove) {
        switch (typeMove) {
            case TypeOfMove.TYPE_MOVE_KING_OR_QUEEN: {
                return new KingOrQueenMove();
            }
            case TypeOfMove.TYPE_MOVE_BISHSPO: {
                return new BishopMove();
            }
            case TypeOfMove.TYPE_MOVE_ROOK: {
                return new RookMove();
            }
            case TypeOfMove.TYPE_MOVE_KNIGHT: {
                return new KnightMove();
            }

        }
        return null;
    }
}
