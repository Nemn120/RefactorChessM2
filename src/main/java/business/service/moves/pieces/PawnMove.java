package business.service.moves.pieces;

import gui.board.ChessGameBoard;
import util.ColorOfPiece;
import util.IsEnemy;
import util.IsOnScreen;

import java.util.ArrayList;

public class PawnMove  implements  IPawnMove {

    public ArrayList<String> calculatePossibleMoves(ChessGameBoard board, int row, int column, int color, boolean isNotMoved) {
        ArrayList<String> moves = new ArrayList<String>();
        if (IsOnScreen.invoke(row, column)) {
            int currRow =
                    color == ColorOfPiece.WHITE
                            ? (row - 1)
                            : (row + 1);
            int count = 1;
            int maxIter =isNotMoved ? 2 : 1;
            // check for normal moves
            while (count <= maxIter) { // only loop while we have open slots and have not passed our
                // limit
                if (IsOnScreen.invoke(currRow, column)
                        && board.getCell(currRow,
                        column).getPieceOnSquare() == null) {
                    moves.add(currRow + "," + column);
                } else {
                    break;
                }
                currRow =
                        (color == ColorOfPiece.WHITE)
                                ? (currRow - 1)
                                : (currRow + 1);
                count++;
            }
            // check for enemy capture points
            if (color == ColorOfPiece.WHITE) {
                if (IsEnemy.invoke(board, row - 1, column - 1,color)) {
                    moves.add((row - 1) + "," + (column - 1));
                }
                if (IsEnemy.invoke(board, row - 1, column + 1,color)) {
                    moves.add((row - 1) + "," + (column + 1));
                }
            } else {
                if (IsEnemy.invoke(board, row + 1, column - 1,color)) {
                    moves.add((row + 1) + "," + (column - 1));
                }
                if (IsEnemy.invoke(board, row + 1, column + 1,color)) {
                    moves.add((row + 1) + "," + (column + 1));
                }
            }
        }
        return moves;
    }
    
}
