package business.service.moves.cardinal.builder;

import gui.board.ChessGameBoard;
import util.CardinalPoint;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

public class MoveBuilderTest {
    
    Logger logger;
    ChessGameBoard chessGameBoard;

    @Before
    public void before(){
        logger = Logger.getLogger(MoveBuilderTest.class.getName());

        chessGameBoard=new ChessGameBoard();
    }

    @Test
    public void patternMethodBuilderValidator() {
        Move.Builder builder = new Move.Builder();
        Move east = builder.addMove(CardinalPoint.EAST, 8).build();
        Move north = builder.addMove(CardinalPoint.NORTH, 8).build();
        Position knightPosition = new Position(0,1);
        Move knightSE = builder.addMove(CardinalPoint.SOUTH, 2).addMove(CardinalPoint.EAST, 1).addPosition(knightPosition).build();
        Move knightSW = builder.addMove(CardinalPoint.SOUTH, 2).addMove(CardinalPoint.WEST, 1).addPosition(knightPosition).build();
        Move east2 = builder.addMove(CardinalPoint.EAST, 8).addPosition(2,2).build();
        Move north2 = builder.addMove(CardinalPoint.NORTH, 8).addPosition(5,3).build();
        //posiciones esperadas
        String expectedEast = "[(0,1), (0,2), (0,3), (0,4), (0,5), (0,6), (0,7), (0,8)]";//+1 columna
        String expectedNorth = "[(-1,0), (-2,0), (-3,0), (-4,0), (-5,0), (-6,0), (-7,0), (-8,0)]";//-1 fila
        String expectedKnightSE = "[(1,1), (2,1), (2,2)]";//+2 fila y +1 columna
        String expectedknightSW = "[(1,1), (2,1), (2,0)]";//+2 fila y -1 columna
        //celdas válidas esperadas
        String expectedEast2 = "[(2,3), (2,4), (2,5), (2,6), (2,7)]";
        String expectedNorth2 = "[(4,3), (3,3), (2,3), (1,3), (0,3)]";
        //comparamos las posiciones y celdas esperadas con las posiciones y celdas reales
        assertEquals(expectedEast,east.getPositions().toString());
        assertEquals(expectedNorth,north.getPositions().toString());
        assertEquals(expectedKnightSE,knightSE.getPositions().toString());
        assertEquals(expectedknightSW,knightSW.getPositions().toString());
        assertEquals(expectedEast2,east2.getValidCells().toString());
        assertEquals(expectedNorth2,north2.getValidCells().toString());
        
    }

}
