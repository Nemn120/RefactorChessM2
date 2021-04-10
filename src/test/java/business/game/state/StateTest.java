package business.game.state;

import gui.ChessPanel;
import gui.board.BoardSquare;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.awt.event.MouseEvent;
import java.util.logging.Logger;

public class StateTest {
    
    Logger logger;
    
    ChessPanel chessPanel;

    @Before
    public void before(){
        logger = Logger.getLogger(StateTest.class.getName());

        chessPanel = new ChessPanel();
    }

    public void simulateClick(BoardSquare cell){
        cell.getMouseListeners()[0].mouseClicked(new MouseEvent(cell,
        MouseEvent.MOUSE_CLICKED, 0, MouseEvent.BUTTON1_MASK, 0, 0, 1, false));
    }

    @Test
    public void patternStateValidatorCheckMate() {
        //blanco
        simulateClick(chessPanel.getGameBoard().getCell(6, 1));//peon delante del caballo
        simulateClick(chessPanel.getGameBoard().getCell(5, 1));//avanza 1
        //negro
        simulateClick(chessPanel.getGameBoard().getCell(1, 4));//peon delante del rey
        simulateClick(chessPanel.getGameBoard().getCell(2, 4));//avanza 1
        //blanco
        simulateClick(chessPanel.getGameBoard().getCell(7, 1));//caballo
        simulateClick(chessPanel.getGameBoard().getCell(5, 2));
        //negro
        simulateClick(chessPanel.getGameBoard().getCell(0, 3));//reina
        simulateClick(chessPanel.getGameBoard().getCell(4, 7));
        //blanco
        simulateClick(chessPanel.getGameBoard().getCell(6, 0));//peon delante de la torre
        simulateClick(chessPanel.getGameBoard().getCell(5, 0));//avanza 1
        //negro
        simulateClick(chessPanel.getGameBoard().getCell(0, 5));//alfil
        simulateClick(chessPanel.getGameBoard().getCell(3, 2));
        //blanco
        simulateClick(chessPanel.getGameBoard().getCell(5, 1));//peon del inicio
        simulateClick(chessPanel.getGameBoard().getCell(4, 1));//avanza 1 nuevamente
        //estado
        logger.info("State: "+chessPanel.getGameEngine().getState().getType());
        assertEquals(State.NORMAL,chessPanel.getGameEngine().getState().getType());
        //negro (ultimo)
        simulateClick(chessPanel.getGameBoard().getCell(4, 7)); //reina
        simulateClick(chessPanel.getGameBoard().getCell(6, 5));
        //estado
        logger.info("State: "+chessPanel.getGameEngine().getState().getType());
        assertEquals(State.CHECKMATE,chessPanel.getGameEngine().getState().getType());
        logger.info("Winner: "+chessPanel.getGameEngine().getState().getWinner());
        assertEquals(2,chessPanel.getGameEngine().getState().getWinner());
        logger.info("Loser: "+chessPanel.getGameEngine().getState().getLoser());
        assertEquals(1,chessPanel.getGameEngine().getState().getLoser());
    }

    @Test
    public void patternStateValidatorCheck() {
        //blanco
        simulateClick(chessPanel.getGameBoard().getCell(6, 1));//peon delante del caballo
        simulateClick(chessPanel.getGameBoard().getCell(5, 1));//avanza 1
        //negro
        simulateClick(chessPanel.getGameBoard().getCell(1, 4));//peon delante del rey
        simulateClick(chessPanel.getGameBoard().getCell(2, 4));//avanza 1
        //blanco
        simulateClick(chessPanel.getGameBoard().getCell(7, 1));//caballo
        simulateClick(chessPanel.getGameBoard().getCell(5, 2));
        //negro
        simulateClick(chessPanel.getGameBoard().getCell(0, 3));//reina
        simulateClick(chessPanel.getGameBoard().getCell(4, 7));
        //blanco
        simulateClick(chessPanel.getGameBoard().getCell(6, 0));//peon delante de la torre
        simulateClick(chessPanel.getGameBoard().getCell(5, 0));//avanza 1
        //estado
        logger.info("State: "+chessPanel.getGameEngine().getState().getType());
        assertEquals(State.NORMAL,chessPanel.getGameEngine().getState().getType());
        //negro 
        simulateClick(chessPanel.getGameBoard().getCell(4, 7)); //reina
        simulateClick(chessPanel.getGameBoard().getCell(6, 5));
        //estado
        logger.info("State: "+chessPanel.getGameEngine().getState().getType());
        assertEquals(State.CHECK,chessPanel.getGameEngine().getState().getType());
        logger.info("Player in check: "+chessPanel.getGameEngine().getState().getPlayerInCheck());
        assertEquals(1,chessPanel.getGameEngine().getState().getPlayerInCheck());
        //blanco
        simulateClick(chessPanel.getGameBoard().getCell(7, 4));//rey
        simulateClick(chessPanel.getGameBoard().getCell(6, 5));
        logger.info("State: "+chessPanel.getGameEngine().getState().getType());
        assertEquals(State.NORMAL,chessPanel.getGameEngine().getState().getType());
    }
}
