package business.pieces;

import gui.board.ChessGameBoard;
import org.junit.Before;
import org.junit.Test;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {
    Logger logger;

    Knight caballoBlack;
    //Knight caballoWhite;
    ChessGameBoard chessGameBoard;

    @Before
    public void before(){
        logger = Logger.getLogger(KnightTest.class.getName());
        chessGameBoard=new ChessGameBoard();
        caballoBlack=new Knight(chessGameBoard,0,1,0);//row=0; col=1,6; color=0 black
        //caballoWhite=new Knight(chessGameBoard,7,1,0);//row=7; col=1,6; color=1 white
    }

    @Test
    public void testCalculatePossibleMovesKnightBlack1(){
        List<String> esperado=new ArrayList<>();
        esperado.add("2,2");
        esperado.add("2,0");

        caballoBlack.calculatePossibleMoves(chessGameBoard);

        logger.info("ExpectedKnightBlack: "+esperado);
        logger.info("ActualKnightBlack: "+caballoBlack.getPossibleMoves());
        assertArrayEquals(esperado.toArray(),caballoBlack.getPossibleMoves().toArray());
    }

    @Test
    public void testCalculatePossibleMovesKnightBlack2(){
        List<String> esperado=new ArrayList<>();
        esperado.add("2,2");
        esperado.add("2,0");
        esperado.add("1,3");

        chessGameBoard.clearCell(1,3);
        caballoBlack.calculatePossibleMoves(chessGameBoard);

        logger.info("ExpectedKnightBlack: "+esperado);
        logger.info("ActualKnightBlack: "+caballoBlack.getPossibleMoves());
        assertArrayEquals(esperado.toArray(),caballoBlack.getPossibleMoves().toArray());
    }

}
