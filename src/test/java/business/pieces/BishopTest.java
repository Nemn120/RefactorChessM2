package business.pieces;

import gui.board.ChessGameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

public class BishopTest {
    Logger logger;

    Bishop bishopBlack;
    //Bishop bishopWhite;
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

        Assert.assertArrayEquals(expected.toArray(),bishopBlack.possibleMoves.toArray());

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
        Assert.assertArrayEquals(expected.toArray(),bishopBlack.possibleMoves.toArray());
    }

}
