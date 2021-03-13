package business.pieces;

import business.service.moves.pieces.PieceMove;
import util.ColorOfPiece;
import gui.board.ChessGameBoard;
import util.ResourceOfPiece;

import javax.swing.*;
import java.util.List;

/**
 * Abstract class that is used to represent a game piece on the chess board.
 * Classes to extend this piece are Rook, Bishop, Knight, Queen, King and Pawn.
 * Also contains a large number of methods to determine information about cells
 * around this piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
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

    /**
     * Create a new GamePiece object.
     *
     * @param board      the board to create this piece on
     * @param row        row of the GamePiece
     * @param col        column of the GamePiece
     * @param pieceColor either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
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

    /**
     * Create a new GamePiece object. This constructor is used for special
     * pieces like pawn, which require other actions to occur before moves are
     * generated. (the pawn can move twice on its initialization, for example)
     *
     * @param board              the board to place the piece on
     * @param row                the row to place the piece on
     * @param col                the column to place the piece on
     * @param skipMoveGeneration if true, moves will not be generated in the constructor
     * @param pieceColor         either GamePiece.BLACK, WHITE, or UNASSIGNED
     */
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

    /**
     * Sets the internal piece location.
     *
     * @param row the new row of the piece
     * @param col the new column of the piece
     */
    public void setPieceLocation(int row, int col) {
        pieceRow = row;
        pieceColumn = col;
    }

    /**
     * Returns this piece's row location.
     *
     * @return int the row
     */
    public int getRow() {
        return pieceRow;
    }

    /**
     * Returns this piece's column.
     *
     * @return int the column
     */
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

    /**
     * Returns a string representation of this piece. Includes piece type and
     * location.
     *
     * @return String the string representation
     */
    @Override
    public String toString() {
        return this.getClass().toString().substring(6) + " @ (" + pieceRow
                + ", " + pieceColumn + ")";
    }
}
