package util.colorFlyWeight;

import business.pieces.Bishop;
import gui.board.ChessGameBoard;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import util.ResourceOfPiece;
import util.colorFactory.ColorfactoryTest;

import java.awt.*;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class ColorFactoryFlyWeightTest {

    Logger logger;
    Bishop bishopBlack;
    ChessGameBoard chessGameBoard;

    @Before
    public void before(){
        logger = Logger.getLogger(ColorfactoryTest.class.getName());
        chessGameBoard=new ChessGameBoard();
        bishopBlack=new Bishop(chessGameBoard,0,2,0);//row=0; col=2,5; color=0 black
    }

    @Test
    public void testRaceCar() throws Exception{
        ResourceOfPiece colors[] = {
            new ResourceOfPiece(0),
            new ResourceOfPiece(1),
            new ResourceOfPiece(3),
            new ResourceOfPiece(1),
            new ResourceOfPiece(1),
        } ;
        colors[0].resourceByType("Bishop");
        colors[1].resourceByType("Bishop");
        colors[2].resourceByType("Bishop");
        colors[2].resourceByType("Knight");
        colors[2].resourceByType("Pawn");
        assertNotNull(colors);
        assertEquals(1,BlackFlyWeight.num);
        assertEquals(1,WhiteFlyWeight.num);
        assertEquals(1,NullFlyWeight.num);
        System.out.println("BLACK INSTANCES: " + BlackFlyWeight.num);
        System.out.println("WHITE INSTANCES: " + WhiteFlyWeight.num);
        System.out.println("UNDEFINED INSTANCES: " + NullFlyWeight.num);



    }

}