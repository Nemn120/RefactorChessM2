package gui.patternCompositeEntity;

import gui.ChessGraveyard;
import gui.ChessMenuBarTest;
import gui.ChessPanel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompositeEntityTest {
    Logger logger;
    CompositeEntity compositeEntity;
    ChessGraveyard player1Graveyard;

    @Before
    public void before() {
        logger = Logger.getLogger(CompositeEntityTest.class.getName());
        compositeEntity = new CompositeEntity();
        player1Graveyard = new ChessGraveyard("Player 1");

    }

    @Test
    public void validatePatternCompositeEntity() {
        assertEquals(true, setDeadsForPlayer1(9));
        compositeEntity.setDataOfPlayers("Player 1", player1Graveyard.getNumDeadsWhitePiece());
        logger.info(compositeEntity.getData());
    }

    @Test
    public void invalidePatternCompositeEntity() {
        assertNotEquals(true, setDeadsForPlayer1(17));
        compositeEntity.setDataOfPlayers("Player 1", player1Graveyard.getNumDeadsWhitePiece());
        logger.info(compositeEntity.getData());
    }

    public boolean setDeadsForPlayer1(int numDeads) {
        int totalNumPiecesWhite = 16;
        boolean validateTotalDeads = false;
        player1Graveyard.setNumDeadsWhitePiece(numDeads++);
        if(player1Graveyard.getNumDeadsWhitePiece() < totalNumPiecesWhite) {
            validateTotalDeads = true;
        }
        return validateTotalDeads;
    }

}