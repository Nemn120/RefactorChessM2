package business.service.moves.pieces;

import business.service.moves.cardinal.CalculateCardinalMove;
import business.service.moves.cardinal.ICalculateCardinalKnightMove;
import util.ColorOfPiece;
import util.TypeOfMove;

import java.util.List;

public abstract class FacadeMoveByPiece {

    public static List<?> movePiece(String typePiece, int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
        ICreateMove createMovePice = CreateMoveFactory.getInstance(typePiece);
        switch (typePiece) {
            case TypeOfMove.TYPE_MOVE_BISHOP:
                List<CalculateCardinalMove> moveBishop = (List<CalculateCardinalMove>)createMovePice.createMove(pieceRow,pieceColumn,colorOfPiece);
                return moveBishop;

            case TypeOfMove.TYPE_MOVE_ROOK:
                List<CalculateCardinalMove> moveRook = (List<CalculateCardinalMove>)createMovePice.createMove(pieceRow,pieceColumn,colorOfPiece);
                return moveRook;

            case TypeOfMove.TYPE_MOVE_KING_OR_QUEEN:
                List<CalculateCardinalMove> moveKingOrQueen = (List<CalculateCardinalMove>)createMovePice.createMove(pieceRow,pieceColumn,colorOfPiece);
                return moveKingOrQueen;

            case TypeOfMove.TYPE_MOVE_KNIGHT:
                List<ICalculateCardinalKnightMove> moveKnight = (List<ICalculateCardinalKnightMove>)createMovePice.createMove(pieceRow,pieceColumn,colorOfPiece);
                return moveKnight;
        }
        return null;
    }

}
