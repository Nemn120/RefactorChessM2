package business.service.moves.pieces;

import business.service.moves.cardinal.CalculateCardinalMove;
import business.service.moves.cardinal.impl.CalculateEastMoves;
import business.service.moves.cardinal.impl.CalculateNorthMoves;
import business.service.moves.cardinal.impl.CalculateSouthMoves;
import business.service.moves.cardinal.impl.CalculateWestMoves;
import util.ColorOfPiece;

import java.util.Arrays;
import java.util.List;

public class RookMove implements ICreateMove{

    @Override
    public List<CalculateCardinalMove> createMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        return Arrays.asList(new CalculateSouthMoves(pieceRow,pieceColumn,color),
                new CalculateNorthMoves(pieceRow,pieceColumn,color),
                new CalculateEastMoves(pieceRow,pieceColumn,color),
                new CalculateWestMoves(pieceRow,pieceColumn,color));
    }
}
