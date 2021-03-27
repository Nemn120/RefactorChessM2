package business.service.moves.cardinal.impl;

import business.service.moves.cardinal.CalculateCardinalMove;
import business.service.moves.cardinal.builder.Move;
import business.service.moves.cardinal.builder.Position;
import util.CardinalPoint;
import util.ColorOfPiece;
import util.IsEnemy;
import util.IsOnScreen;
import gui.board.ChessGameBoard;

import java.util.ArrayList;

public class CalculateSouthMoves extends CalculateCardinalMove {

    public CalculateSouthMoves(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
        super(pieceRow,pieceColumn,colorOfPiece);
    }

    @Override
    public ArrayList<String> invoke(ChessGameBoard board, int numMoves) {
        ArrayList<String> moves = new ArrayList<String>();
        if (IsOnScreen.invoke(getPieceRow(), getPieceColumn())) {
            Move move = new Move.Builder().addMove(CardinalPoint.SOUTH, numMoves).addPosition(getPieceRow(), getPieceColumn()).build();
            ArrayList<Position> cells = move.getValidCells();
            for (int i = 0; i < cells.size(); i++) {
                int row = cells.get(i).getRow();
                int column = cells.get(i).getCol();
                if ((board.getCell(row, column).getPieceOnSquare() == null 
                || IsEnemy.invoke(board, row, column, getColorOfPiece().getColor()))) {
                    moves.add(row + "," + column);
                    if (IsEnemy.invoke(board, row, column, getColorOfPiece().getColor())) {
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
