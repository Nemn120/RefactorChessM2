package business.service.moves.cardinal.impl;

import business.service.moves.cardinal.ICalculateCardinalKnightMove;
import business.service.moves.cardinal.builder.Move;
import business.service.moves.cardinal.builder.Position;
import gui.board.ChessGameBoard;
import util.CardinalPoint;
import util.ColorOfPiece;
import util.IsEnemy;
import util.IsOnScreen;

import java.util.ArrayList;

public class CalculateKnightNorthMoves implements ICalculateCardinalKnightMove {
    private int pieceRow;
    private int pieceColumn;
    private ColorOfPiece colorOfPiece;

    public CalculateKnightNorthMoves(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
        this.pieceRow = pieceRow;
        this.pieceColumn = pieceColumn;
        this.colorOfPiece = colorOfPiece;
    }

    @Override
    public ArrayList<String> invoke(ChessGameBoard board) {
        ArrayList<String> moves = new ArrayList<String>();
        Move.Builder builder = new Move.Builder();
        Move moveNE1 = builder.addMove(CardinalPoint.NORTH, 2).addPosition(pieceRow,pieceColumn).addMove(CardinalPoint.EAST, 1).build();
        Move moveNW1 = builder.addMove(CardinalPoint.NORTH, 2).addPosition(pieceRow,pieceColumn).addMove(CardinalPoint.WEST, 1).build();
        Move moveNE2 = builder.addMove(CardinalPoint.NORTH, 1).addPosition(pieceRow,pieceColumn).addMove(CardinalPoint.EAST, 2).build();
        Move moveNW2 = builder.addMove(CardinalPoint.NORTH, 1).addPosition(pieceRow,pieceColumn).addMove(CardinalPoint.WEST, 2).build();
        ArrayList<Position> cells = new ArrayList<Position>();
        ArrayList<Move> totalMoves = new ArrayList<Move>();
        totalMoves.add(moveNE1);totalMoves.add(moveNW1);totalMoves.add(moveNE2);totalMoves.add(moveNW2);
        for (int i = 0; i < totalMoves.size(); i++) {
            if(totalMoves.get(i).getValidCells().size()==totalMoves.get(i).getPositions().size()){
                cells.add(totalMoves.get(i).getPositions().get(totalMoves.get(i).getPositions().size()-1));
            }
        }
        for (int i = 0; i < cells.size(); i++) {
            int row = cells.get(i).getRow();
            int column = cells.get(i).getCol();
            if (IsOnScreen.invoke(row, column)
                        && (IsEnemy.invoke(board, row, column,colorOfPiece.getColor()) ||
                        board.getCell(row,column).getPieceOnSquare() == null)) {
                    moves.add(row + "," + column);
                }
        }
        return moves;
    }
}
