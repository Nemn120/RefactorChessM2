package business.pieces;

import gui.board.ChessGameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

public class QueenTest {
    Logger logger;

    private Queen queenBlack;
    //private Queen queenWhite;
    ChessGameBoard chessGameBoard;

    @Before
    public void setUp(){
        logger = Logger.getLogger(BishopTest.class.getName());

        chessGameBoard = new ChessGameBoard();
        queenBlack = new Queen(chessGameBoard,0,3,0);
        //queenWhite=new Queen(chessGameBoard,7,3,0);
    }

    @Test
    public void calculatePossibleMovesQueenBlack(){
        ArrayList<String> expected=new ArrayList<>();

        queenBlack.calculatePossibleMoves(chessGameBoard);

        logger.info("Expected: "+expected);
        logger.info("Actual: "+queenBlack.possibleMoves);
        Assert.assertArrayEquals(expected.toArray(),queenBlack.possibleMoves.toArray());

    }

    @Test
    public void calculatePossibleMovesQueenBlack2(){
        ArrayList<String> expected=new ArrayList<>();
        expected.add("1,3");
        expected.add("2,3");
        expected.add("3,3");
        expected.add("4,3");
        expected.add("5,3");
        expected.add("6,3");

        chessGameBoard.clearCell(1,3);
        queenBlack.calculatePossibleMoves(chessGameBoard);

        logger.info("Expected: "+expected);
        logger.info("Actual: "+queenBlack.possibleMoves);
        Assert.assertArrayEquals(expected.toArray(),queenBlack.possibleMoves.toArray());
    }

}