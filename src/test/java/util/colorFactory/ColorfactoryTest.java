package util.colorFactory;

import business.pieces.Bishop;
import business.pieces.BishopTest;
import gui.board.ChessGameBoard;
import org.junit.Before;
import org.junit.Test;
import util.Color;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class ColorfactoryTest {

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
    public void PatternNullValidColor(){
        String[] typeOfColors = new String[]{
                "black","white"
        };
        for(String typeOfColor : typeOfColors){
            Color color = Colorfactory.createColor(typeOfColor);
            logger.info("OBJETO NO NULO: "+color.toString());
            logger.info("RUTA COLOR " + typeOfColor + ": " + color.colorLink("Bishop"));
            assertNotNull(color);
        }
    }

    @Test
    public void PatternNullInvalidColor(){
        bishopBlack=new Bishop(chessGameBoard,0,2,0);
        String typeOfColors = null;
        Color color = Colorfactory.createColor(typeOfColors);
        logger.info("OBJETO NULO: "+color.toString());
        logger.info("RUTA PREDETERMINADA: " + color.colorLink("Bishop"));
        assertNotNull(color);
    }
}











