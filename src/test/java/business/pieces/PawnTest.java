package business.pieces;

import business.service.moves.IPieceMoveService;
import business.service.moves.impl.PieceMoveServiceImpl;
import gui.board.ChessGameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

public class PawnTest {
    Logger logger;

    Pawn pawnBlack;
    ChessGameBoard chessGameBoard;
    IPieceMoveService pieceMoveService;

    @Before
    public void setUp(){
        logger = Logger.getLogger(PawnTest.class.getName());

        chessGameBoard=new ChessGameBoard();
        pieceMoveService = PieceMoveServiceImpl.getInstance();
        pawnBlack=new Pawn(chessGameBoard,1,1,0);//row=1;col=[0,7];color=0 black
        //pawnWhite=new Pawn(chessGameBoard,6,1,1);//row=6;col=[0,7];color=1 white

    }

    @Test
    public void calculatePossibleMovesPawnBlack(){
        ArrayList<String> expected=new ArrayList<>();
        expected.add("2,1");
        expected.add("3,1");

        pawnBlack.calculatePossibleMoves(chessGameBoard);

        Assert.assertArrayEquals(expected.toArray(),pawnBlack.possibleMoves.toArray());

        logger.info("Expected: "+expected);
        logger.info("Actual: "+pawnBlack.possibleMoves);
    }

    @Test
    public void setNotMovedPawnBlack(){
        pawnBlack.setNotMoved(true);
        Assert.assertTrue(pawnBlack.isNotMoved());
    }
}
