package business.objectPool;

import business.pieces.ChessGamePiece;
import business.pieces.factory.PieceFactoryTest;
import gui.board.ChessGameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ColorOfPiece;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectPoolTest {

    ChessGamePiece chessGamePiece;
    ChessGameBoard chessGameBoard;

    @Before
    public void before(){
        chessGameBoard=new ChessGameBoard();
    }

    @Test
    public void ObjectPoolTestImp(){
        ObjectPool op = ObjectPool.getInstance("Bishop",chessGameBoard,0,0,0);
        System.out.println(op.get_pool().size());
        chessGamePiece = op.getPiece("Bishop",chessGameBoard,0,0,0);
        System.out.println(op.get_pool().size());
        assertEquals(0,op.get_pool().size());
        op.returnPiece(chessGamePiece);
        assertEquals(1,op.get_pool().size());
    }
}