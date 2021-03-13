package business.pieces;

import business.service.moves.pieces.PieceMove;
import util.ColorOfPiece;
import gui.board.ChessGameBoard;
import util.ResourceOfPiece;

import javax.swing.*;
import java.util.List;

public abstract class ChessGamePiece {
    protected boolean skipMoveGeneration;
    protected ColorOfPiece colorOfPiece;
    protected ImageIcon pieceImage;
    protected PieceMove pieceMove;
    protected ResourceOfPiece resourceOfPiece;
    /**
     * The list of possible moves for this piece. Updated when actions involving
     * this piece occur. (created, moved, selected, etc)
     */
    protected List<String> possibleMoves;
    /**
     * The game piece's row.
     */
    protected int pieceRow;
    /**
     * The game piece's column.
     */
    protected int pieceColumn;

    public ChessGamePiece(){

    }

    public ChessGamePiece(ChessGameBoard board, int row, int col, int pieceColor) {
        skipMoveGeneration = false;
        this.colorOfPiece = new ColorOfPiece(pieceColor);
        this.resourceOfPiece = new ResourceOfPiece(pieceColor);
        pieceImage = createImageByPieceType();
        pieceRow = row;
        pieceColumn = col;
        if (board.getCell(row, col) != null) {
            board.getCell(row, col).setPieceOnSquare(this);
        }
    }

    public ChessGamePiece(ChessGamePiece piece,ChessGameBoard board){
        if(piece != null){ // PATRON DE JORDY
            this.skipMoveGeneration = piece.isSkipMoveGeneration();
            this.colorOfPiece = piece.getColorOfPiece();
            this.pieceColumn = piece.getColumn();
            this.pieceRow = piece.getRow();
            this.resourceOfPiece =piece.getResourceOfPiece();
            this.pieceMove = piece.getPieceMove();
            this.pieceImage = piece.getPieceImage();
            this.possibleMoves = piece.getPossibleMoves();
            if (board.getCell(this.pieceRow, this.pieceRow) != null) {
                board.getCell(this.pieceRow, this.pieceRow).setPieceOnSquare(this);
            }
        }
    }

    /**
     * Create a new GamePiece object. This constructor is used for special
     * pieces like pawn, which require other actions to occur before moves are
     * generated. (the pawn can move twice on its initialization, for example)
     */

    public boolean isNull(){
        return false;
    }

    public ChessGamePiece(ChessGameBoard board, int row, int col, int pieceColor, boolean skipMoveGeneration) {
        this.skipMoveGeneration = skipMoveGeneration;
        this.colorOfPiece = new ColorOfPiece(pieceColor);
        this.resourceOfPiece = new ResourceOfPiece(pieceColor);
        pieceImage = this.createImageByPieceType();
        pieceRow = row;
        pieceColumn = col;
        if (board.getCell(row, col) != null) {
            board.getCell(row, col).setPieceOnSquare(this);
        }
    }

    public abstract ChessGamePiece clone(ChessGameBoard board);

    public ChessGamePiece(ChessGameBoard board) {

    }

    public abstract void calculatePossibleMoves(ChessGameBoard board);

    /**
     * Creates the ImageIcon by the color of the piece.
     *
     * @return ImageIcon the image that represents this game piece, different
     * for each piece.
     */
    public abstract ImageIcon createImageByPieceType();

    /**
     * Return the ImageIcon as an Image.
     *
     * @return ImageIcon The ImageIcon as an Image
     */
    public ImageIcon getImage() {
        return pieceImage;
    }

    public ColorOfPiece getColorOfPiece(){
        return colorOfPiece;
    }

    public void setPieceLocation(int row, int col) {
        pieceRow = row;
        pieceColumn = col;
    }

    public int getRow() {
        return pieceRow;
    }

    public int getColumn() {
        return pieceColumn;
    }


    public boolean isSkipMoveGeneration() {
        return skipMoveGeneration;
    }

    public void setSkipMoveGeneration(boolean skipMoveGeneration) {
        this.skipMoveGeneration = skipMoveGeneration;
    }

    public List<String> getPossibleMoves() {
        return possibleMoves;
    }

    public void setPossibleMoves(List<String> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    public void setColorOfPiece(ColorOfPiece colorOfPiece) {
        this.colorOfPiece = colorOfPiece;
    }

    public ImageIcon getPieceImage() {
        return pieceImage;
    }

    public void setPieceImage(ImageIcon pieceImage) {
        this.pieceImage = pieceImage;
    }

    public PieceMove getPieceMove() {
        return pieceMove;
    }

    public void setPieceMove(PieceMove pieceMove) {
        this.pieceMove = pieceMove;
    }

    public ResourceOfPiece getResourceOfPiece() {
        return resourceOfPiece;
    }

    public void setResourceOfPiece(ResourceOfPiece resourceOfPiece) {
        this.resourceOfPiece = resourceOfPiece;
    }


    @Override
    public String toString() {
        return "ChessGamePiece{" +
                "skipMoveGeneration=" + skipMoveGeneration +
                ", colorOfPiece=" + colorOfPiece +
                ", pieceImage=" + pieceImage +
                ", pieceMove=" + pieceMove +
                ", resourceOfPiece=" + resourceOfPiece +
                ", possibleMoves=" + possibleMoves +
                ", pieceRow=" + pieceRow +
                ", pieceColumn=" + pieceColumn +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessGamePiece that = (ChessGamePiece) o;
        return skipMoveGeneration == that.skipMoveGeneration && pieceRow == that.pieceRow
                && pieceColumn == that.pieceColumn && colorOfPiece.equals(that.colorOfPiece)
                && pieceImage.equals(that.pieceImage) && resourceOfPiece.equals(that.resourceOfPiece) && possibleMoves.equals(that.possibleMoves);
    }
}
