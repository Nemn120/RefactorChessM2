package business.service.moves.cardinal;

import util.ColorOfPiece;

public abstract class CalculateCardinalMove implements ICalculateMove {

    private int pieceRow;
    private int pieceColumn;
    private ColorOfPiece colorOfPiece;

    public CalculateCardinalMove(){
    }

    public CalculateCardinalMove(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
        this.pieceRow = pieceRow;
        this.pieceColumn = pieceColumn;
        this.colorOfPiece = colorOfPiece;
    }

    public int getPieceRow() {
        return pieceRow;
    }

    public void setPieceRow(int pieceRow) {
        this.pieceRow = pieceRow;
    }

    public int getPieceColumn() {
        return pieceColumn;
    }

    public void setPieceColumn(int pieceColumn) {
        this.pieceColumn = pieceColumn;
    }

    public ColorOfPiece getColorOfPiece() {
        return colorOfPiece;
    }

    public void setColorOfPiece(ColorOfPiece colorOfPiece) {
        this.colorOfPiece = colorOfPiece;
    }
}
