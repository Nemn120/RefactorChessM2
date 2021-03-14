package business.service.moves.pieces;

import business.service.moves.cardinal.CalculateCardinalMove;
import util.ColorOfPiece;
import util.TypeOfMove;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KingOrQueenMove implements ICreateMove {

    @Override
    public List<CalculateCardinalMove> createMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        List<CalculateCardinalMove> addAllMove = new ArrayList<>();
        ICreateMove createMove = null;
        createMove = CreateMoveFactory.getInstance(TypeOfMove.TYPE_MOVE_BISHSPO);
        addAllMove.addAll((Collection<? extends CalculateCardinalMove>) createMove.createMove(pieceRow,pieceColumn,color));
        createMove = CreateMoveFactory.getInstance(TypeOfMove.TYPE_MOVE_ROOK);
        addAllMove.addAll((Collection<? extends CalculateCardinalMove>) createMove.createMove(pieceRow,pieceColumn,color));
        return addAllMove;
    }
}
