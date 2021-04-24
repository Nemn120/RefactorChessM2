package business.observer;

import gui.ChessGraveyard;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RefereeTest {

    @Test
    public void ObserverPatternTest(){
        ChessGraveyard graveyard1 = new ChessGraveyard("Jugador 1 cementerio");
        ChessGraveyard graveyard2 = new ChessGraveyard("Jugador 2 cementerio");
        int x = graveyard1.getWp() instanceof WhitePieces ? 1 : 0;
        int y = graveyard2.getWp() instanceof BlackPieces ? 1 : 0;
        assertEquals(x, y);
        graveyard1.getBascunian().setDeadPieces(12);
        graveyard2.getBascunian().setDeadPieces(9);
        if(graveyard1.getBascunian().getDeadPieces()==10){
            assertEquals(3,graveyard1.quiereRendirse(1));
        }
        if(graveyard2.getBascunian().getDeadPieces()==10){
            assertEquals(3,graveyard2.quiereRendirse(2));
        }
    }
}