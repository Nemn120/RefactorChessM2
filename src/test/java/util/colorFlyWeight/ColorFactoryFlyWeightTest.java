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
    public void testRaceCar() {
        String[] typeOfColors = new String[]{
                "black","white"
        };
        for(String typeOfColor : typeOfColors){
            Colors color = ColorFactoryFlyWeight.getColor(1);
            logger.info("OBJETO NO NULO: "+color.toString());
            logger.info("RUTA COLOR " + typeOfColor + ": " + color.colorLink("Bishop"));
            assertNotNull(color);
        }

    }

}