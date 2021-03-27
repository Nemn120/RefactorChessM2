package business.pieces.factory;

import business.pieces.*;
import gui.board.ChessGameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class PieceFactoryTest {

    Logger logger;
    ChessGamePiece chessGamePiece;
    ChessGameBoard chessGameBoard;

    @Before
    public void before(){

        chessGameBoard=new ChessGameBoard();

        logger = Logger.getLogger(PieceFactoryTest.class.getName());
        logger.info("-------------------------------------------");

    }

    @Test
    public void testCreatePieceBishop(){

        chessGamePiece=PieceFactory.createPiece("Bishop",chessGameBoard,0,0,0);
        logger.info("Expected: "+ Bishop.class.getName());
        logger.info("Actual: "+chessGamePiece.getClass().getName());
        Assert.assertTrue(chessGamePiece instanceof Bishop);

    }

    @Test
    public void testCreatePieceKing(){

        chessGamePiece=PieceFactory.createPiece("King",chessGameBoard,0,0,0);
        logger.info("Expected: "+ King.class.getName());
        logger.info("Actual: "+chessGamePiece.getClass().getName());
        Assert.assertTrue(chessGamePiece instanceof King);

    }

    @Test
    public void testCreatePieceKnight(){

        chessGamePiece=PieceFactory.createPiece("Knight",chessGameBoard,0,0,0);
        logger.info("Expected: "+ Knight.class.getName());
        logger.info("Actual: "+chessGamePiece.getClass().getName());
        Assert.assertTrue(chessGamePiece instanceof Knight);

    }

    @Test
    public void testCreatePiecePawn(){

        chessGamePiece=PieceFactory.createPiece("Pawn",chessGameBoard,0,0,0);
        logger.info("Expected: "+ Pawn.class.getName());
        logger.info("Actual: "+chessGamePiece.getClass().getName());
        Assert.assertTrue(chessGamePiece instanceof Pawn);

    }

    @Test
    public void testCreatePieceQueen(){

        chessGamePiece=PieceFactory.createPiece("Queen",chessGameBoard,0,0,0);
        logger.info("Expected: "+ Queen.class.getName());
        logger.info("Actual: "+chessGamePiece.getClass().getName());
        Assert.assertTrue(chessGamePiece instanceof Queen);

    }

    @Test
    public void testCreatePieceRook(){

        chessGamePiece=PieceFactory.createPiece("Rook",chessGameBoard,0,0,0);
        logger.info("Expected: "+ Rook.class.getName());
        logger.info("Actual: "+chessGamePiece.getClass().getName());
        Assert.assertTrue(chessGamePiece instanceof Rook);

    }

    @Test
    public void testCreatePieceNull(){

        chessGamePiece=PieceFactory.createPiece("",chessGameBoard,0,0,0);
        logger.info("Expected: null");
        logger.info("Actual: "+chessGamePiece);
        Assert.assertNull(chessGamePiece );

        chessGamePiece=PieceFactory.createPiece("",chessGameBoard,0,0,0);
        logger.info("Expected: null");
        logger.info("Actual: "+chessGamePiece);
        Assert.assertNull(chessGamePiece );

    }


}