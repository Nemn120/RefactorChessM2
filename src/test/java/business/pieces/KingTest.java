package business.pieces;

import gui.board.ChessGameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

public class KingTest {
    Logger logger;

    private King kingBlack;
    //private King kingWhite;
    ChessGameBoard chessGameBoard;

    @Before
    public void setUp(){
        logger = Logger.getLogger(BishopTest.class.getName());

        chessGameBoard = new ChessGameBoard();
        kingBlack=new King(chessGameBoard,0,4,0);//row=0; col=4; color=0 black
        //KingWhite=new King(chessGameBoard,7,4,0);//row=7; col=4; color=1 white
    }

    @Test
    public void calculatePossibleMovesKingBlack(){
        ArrayList<String> expected=new ArrayList<>();

        kingBlack.calculatePossibleMoves(chessGameBoard);

        logger.info("Expected: "+expected);
        logger.info("Actual: "+kingBlack.possibleMoves);
        Assert.assertArrayEquals(expected.toArray(),kingBlack.possibleMoves.toArray());

    }

    @Test
    public void calculatePossibleMovesKingBlack2(){
        ArrayList<String> expected=new ArrayList<>();
        expected.add("1,4");

        chessGameBoard.clearCell(1,4);
        kingBlack.calculatePossibleMoves(chessGameBoard);

        logger.info("Expected: "+expected);
        logger.info("Actual: "+kingBlack.possibleMoves);
        Assert.assertArrayEquals(expected.toArray(),kingBlack.possibleMoves.toArray());
    }
}
