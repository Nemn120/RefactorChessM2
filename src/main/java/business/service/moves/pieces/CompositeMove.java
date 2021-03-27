package business.service.moves.pieces;

import business.service.moves.cardinal.CalculateCardinalMove;
import gui.board.ChessGameBoard;
import util.ColorOfPiece;

import java.util.ArrayList;
import java.util.List;

public class CompositeMove extends CalculateCardinalMove{

    List<CalculateCardinalMove> calculateCardinalMoves = new ArrayList<>();

    public CompositeMove(){
        super();
    }

    public void add(CalculateCardinalMove calculateCardinalMove){
        this.calculateCardinalMoves.add(calculateCardinalMove);
    }

    public void addList(List<CalculateCardinalMove> calculateCardinalMoves){
        this.calculateCardinalMoves.addAll(calculateCardinalMoves);
    }

    public CompositeMove(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
        super(pieceRow, pieceColumn, colorOfPiece);
    }

    public List<CalculateCardinalMove> getCalculateCardinalMoves() {
        return calculateCardinalMoves;
    }

    @Override
    public ArrayList<String> invoke(ChessGameBoard board, int numMoves) {
        return null;
    }
}
