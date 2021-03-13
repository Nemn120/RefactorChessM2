package business.service.moves.cardinal.impl;

import business.service.moves.cardinal.CalculateCardinalMove;
import util.ColorOfPiece;
import util.IsEnemy;
import util.IsOnScreen;
import gui.board.ChessGameBoard;

import java.util.ArrayList;

public class CalculateWestMoves extends CalculateCardinalMove {


    public CalculateWestMoves(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
        super(pieceRow,pieceColumn,colorOfPiece);
    }

    @Override
    public ArrayList<String> invoke(ChessGameBoard board, int numMoves) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (IsOnScreen.invoke(getPieceRow(),getPieceColumn())) {
            for (int i = getPieceColumn() - 1; i >= 0 && count < numMoves; i--) {
                if ((board.getCell(getPieceRow(), i).getPieceOnSquare()
                        == null || IsEnemy.invoke(board, getPieceRow(), i,getColorOfPiece().getColor()))) {
                    moves.add(getPieceRow() + "," + i);
                    count++;
                    if (IsEnemy.invoke(board, getPieceRow(), i,getColorOfPiece().getColor())) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return moves;
    }

  /*  @Override
    public ArrayList<String> invoke(ChessGameBoard board, int numMoves, ChessGamePiece piece) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (IsOnScreen.invoke(pieceRow,pieceColumn)) {
            for (int i = pieceColumn - 1; i >= 0 && count < numMoves; i--) {
                if ((board.getCell(pieceRow, i).getPieceOnSquare()
                        == null || IsEnemy.invoke(board, pieceRow, i,piece.getColorOfPiece().getColor()))) {
                    moves.add(pieceRow + "," + i);
                    count++;
                    if (IsEnemy.invoke(board, pieceRow, i,piece.getColorOfPiece().getColor())) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return moves;
    }

   */
}
