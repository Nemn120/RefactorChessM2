package business.pieces;

import business.factory.PieceChessFactory;
import gui.board.ChessGameBoard;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

import static org.junit.Assert.*;
public class BishopTest {
    Logger logger;

    Bishop bishopBlack;
    ChessGameBoard chessGameBoard;

    @Before
    public void before(){
        logger = Logger.getLogger(BishopTest.class.getName());

        chessGameBoard=new ChessGameBoard();
        bishopBlack=new Bishop(chessGameBoard,0,2,0);//row=0; col=2,5; color=0 black
        //bishopBlack=new Bishop(chessGameBoard,7,2,0);//row=7; col=2,5; color=1 black
    }

    @Test
    public void calculatePossibleMovesBishopBlack(){
        ArrayList<String> expected=new ArrayList<>();

        bishopBlack.calculatePossibleMoves(chessGameBoard);

        assertArrayEquals(expected.toArray(),bishopBlack.possibleMoves.toArray());

        logger.info("Expected: "+expected);
        logger.info("Actual: "+bishopBlack.possibleMoves);
    }

    @Test
    public void calculatePossibleMovesBishopBlack2(){
        ArrayList<String> expected=new ArrayList<>();
        expected.add("1,3");
        expected.add("2,4");
        expected.add("3,5");
        expected.add("4,6");
        expected.add("5,7");
        expected.add("1,1");
        expected.add("2,0");

        chessGameBoard.clearCell(1,1);
        chessGameBoard.clearCell(1,3);
        bishopBlack.calculatePossibleMoves(chessGameBoard);

        logger.info("Expected: "+expected);
        logger.info("Actual: "+bishopBlack.possibleMoves);
    }

    @Test
    public void cloneAndComparePrototypeTest(){

        chessGameBoard=new ChessGameBoard();
        bishopBlack=new Bishop(chessGameBoard,0,2,0);//row=0; col=2,5; color=0 black

        ArrayList<String> expected=new ArrayList<>();
        expected.add("1,3");
        expected.add("2,4");
        expected.add("3,5");
        expected.add("4,6");
        expected.add("5,7");
        expected.add("1,1");
        expected.add("2,0");
        chessGameBoard.clearCell(1,1);
        chessGameBoard.clearCell(1,3);
        bishopBlack.calculatePossibleMoves(chessGameBoard);
        ChessGamePiece bishopClone = bishopBlack.clone(chessGameBoard);

        assertNotNull(bishopClone);
        assertNotNull(bishopClone.getPieceImage());
        assertNotNull(bishopClone.getColumn());
        assertNotNull(bishopClone.getRow());
        assertNotNull(bishopClone.getColorOfPiece());
        assertNotNull(bishopClone.getColorOfPiece().getColor());
        assertNotNull(bishopClone.getImage());
        assertNotNull(bishopClone.getPossibleMoves());
        assertNotNull(bishopClone.getResourceOfPiece());

        assertTrue(bishopClone.equals(bishopBlack));
        assertEquals(bishopBlack.getColumn(),bishopClone.getColumn());
        assertEquals(bishopBlack.getRow(),bishopClone.getRow());
        assertEquals(bishopBlack.getColorOfPiece().getColor(),bishopClone.getColorOfPiece().getColor());
        assertArrayEquals(bishopBlack.getPossibleMoves().toArray(),bishopClone.possibleMoves.toArray());

        logger.info("REAL: "+bishopClone.possibleMoves);
        logger.info("CLONADO: "+bishopBlack.possibleMoves);
        logger.info("OBJECTOBASE"+bishopBlack.toString());
        logger.info("OBJECTOCLON"+bishopClone.toString());
    }

    @Test
    public void PatternNullValidPiece(){
        chessGameBoard=new ChessGameBoard();
        bishopBlack=new Bishop(chessGameBoard,0,2,0);//row=0; col=2,5; color=0 black

        ArrayList<String> expected=new ArrayList<>();
        expected.add("1,3");
        expected.add("2,4");
        expected.add("3,5");
        expected.add("4,6");
        expected.add("5,7");
        expected.add("1,1");
        expected.add("2,0");
        chessGameBoard.clearCell(1,1);
        chessGameBoard.clearCell(1,3);
        bishopBlack.calculatePossibleMoves(chessGameBoard);
        ChessGamePiece bishop = PieceChessFactory.createChessPiece("Bishop",chessGameBoard,0,2,0);
        assertNotNull(bishop);
        assertNotNull(bishop.getPossibleMoves());
        assertArrayEquals(bishopBlack.getPossibleMoves().toArray(),bishop.getPossibleMoves().toArray());
        assertFalse(bishop.isNull());

        logger.info("MOVIMIENTOS POSIBLES: "+bishop.possibleMoves);
        logger.info("OBJETO NO NULO"+bishop.toString());
    }

    @Test
    public void PatternNullInvalidPiece(){
        chessGameBoard=new ChessGameBoard();
        bishopBlack=new Bishop(chessGameBoard,0,2,0);//row=0; col=2,5; color=0 black

        ArrayList<String> expected=new ArrayList<>();
        expected.add("1,3");
        expected.add("2,4");
        expected.add("3,5");
        expected.add("4,6");
        expected.add("5,7");
        expected.add("1,1");
        expected.add("2,0");
        chessGameBoard.clearCell(1,1);
        chessGameBoard.clearCell(1,3);
        bishopBlack.calculatePossibleMoves(chessGameBoard);
        ChessGamePiece bishop = PieceChessFactory.createChessPiece(null,chessGameBoard,0,2,0);
        assertNotNull(bishop);
        assertNull(bishop.getPossibleMoves());
        assertTrue(bishop.isNull());
        bishop.calculatePossibleMoves(chessGameBoard);
        logger.info("OBJETO NULO: "+bishop.toString());
    }

}
