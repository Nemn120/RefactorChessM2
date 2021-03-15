package business.service.moves.pieces;

import business.pieces.Bishop;
import business.pieces.BishopTest;
import gui.board.ChessGameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ColorOfPiece;
import util.TypeOfMove;

import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class CreateMoveFactoryTest {

    Logger logger;
    Bishop bishopBlack;
    ChessGameBoard chessGameBoard;

    @Before
    public void before(){
        logger = Logger.getLogger(CreateMoveFactoryTest.class.getName());

        chessGameBoard=new ChessGameBoard();
        bishopBlack=new Bishop(chessGameBoard,0,2,0);//row=0; col=2,5; color=0 black
    }

    @Test
    public void PatternMethodFactoryValidad() {
        ICreateMove createMoveBishop = CreateMoveFactory.getInstance(TypeOfMove.TYPE_MOVE_BISHOP);
        assertNotNull(createMoveBishop.createMove(0, 2, new ColorOfPiece(0)));
        Assert.assertTrue(createMoveBishop instanceof BishopMove);

        logger.info("OBJETO NO NULO" + createMoveBishop.toString());
    }

}