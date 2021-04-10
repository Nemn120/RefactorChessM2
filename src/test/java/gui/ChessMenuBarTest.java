package gui;

import business.pieces.BishopTest;
import gui.patternCommand.ChessMenuBarInvoker;
import gui.patternCommand.CommandAboutGame;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class ChessMenuBarTest {

    Logger logger;
    ChessMenuBar chessMenuBar;

    @Before
    public void before() {
        logger = Logger.getLogger(ChessMenuBarTest.class.getName());
        chessMenuBar = new ChessMenuBar();
    }

    @Test
    public void validatePatternCommand() {
        ChessPanel parentChessPanel = (ChessPanel) chessMenuBar.getParent();
        boolean validate  = this.validateParentPanel(parentChessPanel);
        assertEquals(true, validate);
        logger.info("EJECUTADO CON EXITO");

    }

    public boolean validateParentPanel(ChessPanel panel) {
        boolean validateParent = false;
        if(panel==null) {
            ChessMenuBarInvoker invoker = new ChessMenuBarInvoker();
            invoker.executeCommand(new CommandAboutGame(panel));
            validateParent = true;
        }
        return validateParent;
    }

}