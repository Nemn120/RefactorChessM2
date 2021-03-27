package business.service.moves.pieces;

import business.service.moves.cardinal.CalculateCardinalMove;
import util.ColorOfPiece;
import util.TypeOfMove;

import java.util.List;

public class KingOrQueenMove implements ICreateMove {

    @Override
    public List<CalculateCardinalMove> createMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        CompositeMove compositeKingOrQueenMove = new CompositeMove();
        ICreateMove createMove = CreateMoveFactory.getInstance(TypeOfMove.TYPE_MOVE_BISHOP);
        compositeKingOrQueenMove.addList(
                (List<CalculateCardinalMove>) createMove.createMove(pieceRow,pieceColumn,color));
        createMove = CreateMoveFactory.getInstance(TypeOfMove.TYPE_MOVE_ROOK);
        compositeKingOrQueenMove.addList(
                (List<CalculateCardinalMove>) createMove.createMove(pieceRow,pieceColumn,color));
        return compositeKingOrQueenMove.getCalculateCardinalMoves();
    }
}
