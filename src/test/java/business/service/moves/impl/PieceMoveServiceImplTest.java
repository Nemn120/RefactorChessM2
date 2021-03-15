package business.service.moves.impl;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceMoveServiceImplTest {

    @Test
    public void pieceMoveServiceImplSingletonTest(){
        PieceMoveServiceImpl x = PieceMoveServiceImpl.getInstance();
        PieceMoveServiceImpl y = PieceMoveServiceImpl.getInstance();
        assertEquals(x,y);
    }
}