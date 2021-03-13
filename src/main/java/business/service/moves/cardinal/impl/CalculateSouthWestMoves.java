package business.service.moves.cardinal.impl;

import business.service.moves.cardinal.CalculateCardinalMove;
import util.ColorOfPiece;
import util.IsEnemy;
import util.IsOnScreen;
import gui.board.ChessGameBoard;

import java.util.ArrayList;

public class CalculateSouthWestMoves extends CalculateCardinalMove {

    public CalculateSouthWestMoves(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
        super(pieceRow,pieceColumn,colorOfPiece);
    }

    @Override
    public ArrayList<String> invoke(ChessGameBoard board, int numMoves) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (IsOnScreen.invoke(getPieceRow(), getPieceColumn())) {
            for (int i = 1; i < 8 && count < numMoves; i++) {
                if (IsOnScreen.invoke(getPieceRow() + i, getPieceColumn() - i)
                        && (board.getCell(getPieceRow() + i,
                        getPieceColumn() - i).getPieceOnSquare() == null)) {
                    moves.add((getPieceRow() + i) + "," + (getPieceColumn() - i));
                    count++;
                } else if (IsEnemy.invoke(board, getPieceRow() + i, getPieceColumn() - i,0)) {
                    moves.add((getPieceRow() + i) + "," + (getPieceColumn() - i));
                    count++;
                    break;
                } else {
                    break;
                }
            }
        }
        return moves;
    }
}
