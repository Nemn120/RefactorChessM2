package business.visitor;

import business.pieces.*;
import business.pieces.factory.PieceFactory;
import gui.board.BoardSquare;
import gui.board.ChessGameBoard;

public class VisitorRestauracion implements Visitor {
    private ChessGameBoard board;
    private BoardSquare cell;
    private int row;
    private int col;

    public VisitorRestauracion(ChessGameBoard board) {
        this.board = board;
    }
    public void setPieceLocation(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public BoardSquare getChessCell(){
        return cell;
    }
    @Override
    public void visitPawn(Pawn pawn) {
        cell = new BoardSquare(row, col, PieceFactory.createPiece("Pawn",
                    board, row, col, pawn.getColorOfPiece().getColor()));
    }
    @Override
    public void visitRook(Rook rook) {
        cell = new BoardSquare(row, col, PieceFactory.createPiece("Rook",
                    board, row, col, rook.getColorOfPiece().getColor()));
    }
    @Override
    public void visitBishop(Bishop bishop) {
        cell = new BoardSquare(row, col, PieceFactory.createPiece("Bishop",
                    board, row, col, bishop.getColorOfPiece().getColor()));
    }
    @Override
    public void visitKnight(Knight knight) {
        cell = new BoardSquare(row, col, PieceFactory.createPiece("Knight",
                    board, row, col, knight.getColorOfPiece().getColor()));
    }
    @Override
    public void visitQueen(Queen queen) {
        cell = new BoardSquare(row, col, PieceFactory.createPiece("Queen",
                    board, row, col, queen.getColorOfPiece().getColor()));
    }
    @Override
    public void visitKing(King king) {
        cell = new BoardSquare(row, col, PieceFactory.createPiece("King",
                    board, row, col, king.getColorOfPiece().getColor()));
    }
}
