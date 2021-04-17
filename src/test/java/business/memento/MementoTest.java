package business.memento;

import business.pieces.ChessGamePiece;
import business.pieces.factory.PieceFactoryTest;
import gui.ChessPanel;
import gui.board.BoardSquare;
import gui.board.ChessGameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class MementoTest {

    Logger logger;

    ChessPanel panel;

    Caretaker caretaker;
    Originator originator;

    @Before
    public void before(){

        panel=new ChessPanel();

        caretaker = new Caretaker();
        originator = new Originator();

        logger = Logger.getLogger(MementoTest.class.getName());
        logger.info("-------------------------------------------");
    }

    @Test
    public void restaurarChess() {
        BoardSquare[][] actualBoard;
        BoardSquare[][] expectedBoard;
        boolean band=true;

        expectedBoard=panel.getGameBoard().getChessCells();
        originator.setEstado(expectedBoard);
        caretaker.addMemento(originator.guardar());

        originator.restaurar(caretaker.getMemento(0));
        actualBoard= originator.getEstado();

        //Comparing two boards
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (expectedBoard[i][j].getPieceOnSquare() != actualBoard[i][j].getPieceOnSquare()) {
                    band=false;
                    logger.info("FILA: "+expectedBoard[i][j].getPieceOnSquare().getRow()+
                            " COLUMNA: "+expectedBoard[i][j].getPieceOnSquare().getColumn());
                    logger.info("-----------------ERROR---------------------");
                }
                if(expectedBoard[i][j].getPieceOnSquare() !=null && actualBoard[i][j].getPieceOnSquare()!=null) {
                    logger.info("Expected: " + expectedBoard[i][j].getPieceOnSquare().getClass().getName());
                    logger.info("Actual: " + actualBoard[i][j].getPieceOnSquare().getClass().getName());
                    logger.info("--------------------OK---------------------");
                }
                assertTrue(band);
            }
        }
    }
}

