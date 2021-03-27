package business.pieces;

import gui.board.ChessGameBoard;
import util.ColorOfPiece;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import business.service.moves.cardinal.CalculateCardinalMove;
import business.service.moves.cardinal.CalculateMovesFactory;
import business.service.moves.cardinal.impl.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class RookTest {
    Logger logger;

    Rook rookBlack;
    //Rook rookWhite;
    ChessGameBoard chessGameBoard;

    @Before
    public void before(){
        logger = Logger.getLogger(RookTest.class.getName());

        chessGameBoard=new ChessGameBoard();
        rookBlack=new Rook(chessGameBoard,0,0,0);//row=0; col=0,7; color=0 black
        //rookWhite=new Rook(chessGameBoard,7,0,1);//row=7; col=0,7; color=1 white
    }

    @Test
    public void calculatePossibleMovesRookBlack(){
        ArrayList<String> expected=new ArrayList<>();

        rookBlack.calculatePossibleMoves(chessGameBoard);

        logger.info("Expected: "+expected);
        logger.info("Actual: "+rookBlack.possibleMoves);
        Assert.assertArrayEquals(expected.toArray(),rookBlack.possibleMoves.toArray());

    }

    @Test
    public void calculatePossibleMovesRookBlack2(){
        ArrayList<String> expected=new ArrayList<>();
        expected.add("1,0");
        expected.add("2,0");
        expected.add("3,0");
        expected.add("4,0");
        expected.add("5,0");
        expected.add("6,0");

        chessGameBoard.clearCell(1,0);
        rookBlack.calculatePossibleMoves(chessGameBoard);

        logger.info("Expected: "+expected);
        logger.info("Actual: "+rookBlack.possibleMoves);
        Assert.assertArrayEquals(expected.toArray(),rookBlack.possibleMoves.toArray());
    }

    @Test
    public void PatternMethodFactoryCalculateCardinalMove(){
        List<CalculateCardinalMove> rookMoves = CalculateMovesFactory.getInstance(0,0,new ColorOfPiece(0),"S","N","E","W");
        Assert.assertEquals(4,rookMoves.size());
        CalculateSouthMoves sm=new CalculateSouthMoves(0,0,new ColorOfPiece(0));
        Assert.assertArrayEquals(Arrays.asList(sm.getPieceRow(),sm.getPieceColumn(),sm.getColorOfPiece().getColor()).toArray(),
        Arrays.asList(rookMoves.get(0).getPieceRow(),rookMoves.get(0).getPieceColumn(),rookMoves.get(0).getColorOfPiece().getColor()).toArray());
        Assert.assertEquals(sm.getClass().getName(),rookMoves.get(0).getClass().getName());
        Assert.assertEquals(new CalculateNorthMoves(0,0,new ColorOfPiece(0)).getClass().getName(),rookMoves.get(1).getClass().getName());
        Assert.assertEquals(new CalculateEastMoves(0,0,new ColorOfPiece(0)).getClass().getName(),rookMoves.get(2).getClass().getName());
        Assert.assertEquals(new CalculateWestMoves(0,0,new ColorOfPiece(0)).getClass().getName(),rookMoves.get(3).getClass().getName());
        logger.info("rookMove 1: " + rookMoves.get(0));
        logger.info("rookMove 2: " + rookMoves.get(1));
        logger.info("rookMove 3: " + rookMoves.get(2));
        logger.info("rookMove 4: " + rookMoves.get(3));
    }
}
