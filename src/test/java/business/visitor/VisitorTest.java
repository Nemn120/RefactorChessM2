package business.visitor;

import gui.board.BoardSquare;
import gui.board.ChessGameBoard;
import util.ColorOfPiece;

import org.junit.Before;
import org.junit.Test;

import business.pieces.Pawn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

public class VisitorTest {
    
    Logger logger;
    
    ChessGameBoard chessGameBoard;
    Pawn pawnBlack;

    @Before
    public void before(){
        logger = Logger.getLogger(VisitorTest.class.getName());

        chessGameBoard = new ChessGameBoard();
    }

    @Test
    public void patternVisitorRestauracion() {
        pawnBlack = new Pawn(chessGameBoard,1,0,0);
        BoardSquare[][] savedBoard = new BoardSquare[8][8];//tabla que hemos guardado
        savedBoard[1][0] = new BoardSquare(1, 0, chessGameBoard.getCell(1, 0).getPieceOnSquare());//peon
        savedBoard[2][0] = new BoardSquare(2, 0, chessGameBoard.getCell(2, 0).getPieceOnSquare());//vacio
        pawnBlack.setPieceLocation(2, 0);
        chessGameBoard.getCell(2, 0).setPieceOnSquare(pawnBlack);
        chessGameBoard.clearCell(1, 0);

        assertEquals(null,chessGameBoard.getCell(1, 0).getPieceOnSquare());
        assertEquals(pawnBlack,chessGameBoard.getCell(2, 0).getPieceOnSquare());

        VisitorRestauracion visitor = new VisitorRestauracion(chessGameBoard);
        for (int i = 1; i < 3; i++) {//probando fila 1 y 2
            for (int j = 0; j < 1; j++) {//probando columna 0
                if(savedBoard[i][j].getPieceOnSquare() != null){
                    visitor.setPieceLocation(i, j);//se ubica en esa posicion
                    savedBoard[i][j].getPieceOnSquare().aceptar(visitor);
                    chessGameBoard.setCell(i, j, visitor.getChessCell());
                }
                else{
                    chessGameBoard.setCell(i, j,new BoardSquare(i, j, null));
                }
            }
        }
        assertTrue(chessGameBoard.getCell(1, 0).getPieceOnSquare() instanceof Pawn);
        assertEquals(1,chessGameBoard.getCell(1, 0).getPieceOnSquare().getRow());
        assertEquals(0,chessGameBoard.getCell(1, 0).getPieceOnSquare().getColumn());
        assertEquals(ColorOfPiece.BLACK,chessGameBoard.getCell(1, 0).getPieceOnSquare()
                        .getColorOfPiece().getColor());
        assertEquals(null,chessGameBoard.getCell(2, 0).getPieceOnSquare());
    }

}
