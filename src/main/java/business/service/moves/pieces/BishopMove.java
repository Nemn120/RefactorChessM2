package business.service.moves.pieces;

import business.service.moves.cardinal.CalculateCardinalMove;
import business.service.moves.cardinal.impl.CalculateNorthEastMoves;
import business.service.moves.cardinal.impl.CalculateNorthWestMoves;
import business.service.moves.cardinal.impl.CalculateSouthEastMoves;
import business.service.moves.cardinal.impl.CalculateSouthWestMoves;
import util.ColorOfPiece;

import java.util.Arrays;
import java.util.List;

public class BishopMove implements ICreateMove{

    @Override
    public List<CalculateCardinalMove> createMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        return Arrays.asList(new CalculateNorthEastMoves(pieceRow,pieceColumn,color),
                new CalculateNorthWestMoves(pieceRow,pieceColumn,color),
                new CalculateSouthEastMoves(pieceRow,pieceColumn,color),
                new CalculateSouthWestMoves(pieceRow,pieceColumn,color));
    }
}
