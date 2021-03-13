package business.service.moves.cardinal.impl;

import business.service.moves.cardinal.CalculateCardinalMove;
import util.ColorOfPiece;
import util.IsEnemy;
import util.IsOnScreen;
import gui.board.ChessGameBoard;

import java.util.ArrayList;

public class CalculateNorthMoves extends CalculateCardinalMove {

    public CalculateNorthMoves(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
        super(pieceRow,pieceColumn,colorOfPiece);
    }

    @Override
    public ArrayList<String> invoke(ChessGameBoard board, int numMoves) {
        ArrayList<String> moves = new ArrayList<>();
        int count = 0;
        if (IsOnScreen.invoke(getPieceRow(),getPieceColumn())) {
            for (int i = getPieceRow() - 1; i >= 0 && count < numMoves; i--) {
                if ((board.getCell(i, getPieceColumn()).getPieceOnSquare()
                        == null || IsEnemy.invoke(board, i, getPieceColumn(),getColorOfPiece().getColor()))) {
                    moves.add(i + "," + getPieceColumn());
                    count++;
                    if (IsEnemy.invoke(board, i, getPieceColumn(),getColorOfPiece().getColor())) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return moves;
    }
}
