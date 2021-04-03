package util.IteratorPattern;

import business.factory.PieceChessFactory;
import business.pieces.Bishop;
import business.pieces.ChessGamePiece;
import gui.board.ChessGameBoard;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import util.IteratorPattern.AgregadoConcreto;
import util.IteratorPattern.Iterador;
import util.colorFactory.ColorfactoryTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class IteradorTest {
    Logger logger;
    Bishop bishopBlack;

    @Before
    public void before(){
        logger = Logger.getLogger(ColorfactoryTest.class.getName());
    }

    @Test
    public void IteradorTestPassed(){
        AgregadoConcreto agregado = new AgregadoConcreto();
        Iterador iterador = agregado.getIterador();
        while(iterador.hasNext() == true){
            System.out.print(iterador.actual() + " | ");
            iterador.next();
        }
        System.out.println();
        assertNotNull(iterador);
        assertEquals("Bishop",iterador.first());
        System.out.println("Primero: "+ iterador.first());
        iterador.next();
        iterador.next();
        assertEquals("Knight",iterador.actual());
        System.out.println("Tercero: " + iterador.actual());
        iterador.next();
        iterador.next();
        iterador.next();
        assertEquals("Rook", iterador.actual());
        System.out.println("Ultimo: " + iterador.actual());
    }

}