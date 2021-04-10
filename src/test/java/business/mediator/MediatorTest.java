package business.mediator;
import business.pieces.Bishop;
import gui.ChessGraveyard;
import gui.board.ChessGameBoard;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import util.ResourceOfPiece;
import util.colorFactory.ColorfactoryTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class MediatorTest {
    Logger logger;
    ChessGraveyard playerOne;
    ChessGraveyard playerTwo;
    Fan fan;

    @Before
    public void before(){
        logger = Logger.getLogger(ColorfactoryTest.class.getName());

    }
}