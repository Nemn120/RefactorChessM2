package business.service.moves.cardinal.abstractFactoryCardinal;

import business.pieces.Bishop;
import gui.board.ChessGameBoard;
import org.junit.Before;
import org.junit.Test;
import util.CardinalPoint;
import util.ColorOfPiece;

import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class ICalculateCardinalFactoryTest {
    Logger logger;

    Bishop bishopBlack;
    ChessGameBoard chessGameBoard;

    @Before
    public void before() {
        logger = Logger.getLogger(ICalculateCardinalFactoryTest.class.getName());
        chessGameBoard=new ChessGameBoard();
        bishopBlack=new Bishop(chessGameBoard,0,2,0);//row=0; col=2,5; color=0 black

    }

    @Test
    public void CalculateCardinal() {
        Object invokeDiagonal = InvokeMoveCardinal.createMoveCardinal(new CalculateCardinalDiagonalFactory());
        CalculateMoveDiagonal moveDiagonal = ((CalculateMoveDiagonal)invokeDiagonal);
        assertNotNull(moveDiagonal.getInstance(0, 2, new ColorOfPiece(0),
                CardinalPoint.NORTHEAST,
                CardinalPoint.NORTHWEST,
                CardinalPoint.SOUTHEAST,
                CardinalPoint.SOUTHWEST));
        assertTrue(moveDiagonal instanceof CalculateMoveDiagonal);

        logger.info("OBJETO NO NULO" + moveDiagonal.toString());
    }

}