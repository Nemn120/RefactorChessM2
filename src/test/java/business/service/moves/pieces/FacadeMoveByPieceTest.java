package business.service.moves.pieces;

import business.pieces.Bishop;
import business.service.moves.cardinal.CalculateCardinalMove;
import gui.board.ChessGameBoard;
import org.junit.Before;
import org.junit.Test;
import util.ColorOfPiece;
import util.TypeOfMove;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;


public class FacadeMoveByPieceTest {

    Logger logger;
    Bishop bishopBlack;
    ChessGameBoard chessGameBoard;

    @Before
    public void before(){
        logger = Logger.getLogger(FacadeMoveByPieceTest.class.getName());
        chessGameBoard=new ChessGameBoard();
        bishopBlack=new Bishop(chessGameBoard,0,2,0);//row=0; col=2,5; color=0 black
    }

    @Test
    public void validatePatternFacade(){
        List<CalculateCardinalMove> moveBishop = (List<CalculateCardinalMove>)FacadeMoveByPiece.movePiece(TypeOfMove.TYPE_MOVE_BISHOP,
                                                                                    0,2,new ColorOfPiece(0));
        PieceMove pieceMove = new PieceMove(moveBishop);
        assertEquals(4, moveBishop.size());
        assertNotNull(pieceMove);
    }

}