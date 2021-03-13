package business.service.moves.pieces;

import business.service.moves.cardinal.CalculateCardinalMove;
import business.service.moves.cardinal.ICalculateCardinalKnightMove;
import business.service.moves.cardinal.impl.*;
import util.ColorOfPiece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateMoveService {

    private static CreateMoveService instance;

    public List<CalculateCardinalMove> kingOrQeenMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        List<CalculateCardinalMove> addAllMove = new ArrayList<>();
        addAllMove.addAll(CreateMoveService.getInstance().bishopMove(pieceRow,pieceColumn,color));
        addAllMove.addAll(CreateMoveService.getInstance().rookMove(pieceRow,pieceColumn,color));
        return addAllMove;
    }

    public List<CalculateCardinalMove> bishopMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        return Arrays.asList(new CalculateNorthEastMoves(pieceRow,pieceColumn,color),
                new CalculateNorthWestMoves(pieceRow,pieceColumn,color),
                new CalculateSouthEastMoves(pieceRow,pieceColumn,color),
                new CalculateSouthWestMoves(pieceRow,pieceColumn,color));
    }

    public List<CalculateCardinalMove> rookMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        return Arrays.asList(new CalculateSouthMoves(pieceRow,pieceColumn,color),
                new CalculateNorthMoves(pieceRow,pieceColumn,color),
                new CalculateEastMoves(pieceRow,pieceColumn,color),
                new CalculateWestMoves(pieceRow,pieceColumn,color));
    }

    public List<ICalculateCardinalKnightMove> knightMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        return Arrays.asList(new CalculateKnightNorthMoves(pieceRow,pieceColumn,color),
                new CalculateKnightSouthMoves(pieceRow,pieceColumn,color));
    }


    public static CreateMoveService getInstance(){
        if(instance==null){
            instance = new CreateMoveService();
        }
        return instance;
    }

}
