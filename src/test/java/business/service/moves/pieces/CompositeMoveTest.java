package business.service.moves.pieces;

import business.service.moves.cardinal.impl.*;
import org.junit.Before;
import org.junit.Test;
import util.ColorOfPiece;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CompositeMoveTest {

    private ColorOfPiece color;

    @Before
    public void init(){
        color = new ColorOfPiece(1);
    }

    @Test
    public void addCalculateCardinalMoveCompositeTest(){
        CompositeMove rookMove = new CompositeMove();
        rookMove.add(new CalculateNorthMoves(0,0,color));
        rookMove.add(new CalculateEastMoves(0,0,color));
        rookMove.add(new CalculateSouthMoves(0,0,color));
        rookMove.add(new CalculateWestMoves(0,0,color));

        CompositeMove bishopMove = new CompositeMove();
        bishopMove.addList(Arrays.asList(new CalculateNorthEastMoves(0,0,color),
                new CalculateNorthWestMoves(0,0,color),
                new CalculateSouthEastMoves(0,0,color),
                new CalculateSouthWestMoves(0,0,color)));

        CompositeMove kingOrQueenMove = new CompositeMove();
        kingOrQueenMove.add(rookMove);
        kingOrQueenMove.add(bishopMove);

        assertEquals(4,bishopMove.getCalculateCardinalMoves().size());
        assertEquals(4,rookMove.getCalculateCardinalMoves().size());

        assertEquals(2,kingOrQueenMove.getCalculateCardinalMoves().size()); // 2 Compuestos
        assertEquals(kingOrQueenMove.getCalculateCardinalMoves().get(0),rookMove);
        assertEquals(kingOrQueenMove.getCalculateCardinalMoves().get(1),bishopMove);

        assertEquals(4,((CompositeMove)kingOrQueenMove.getCalculateCardinalMoves()
                .get(0)).getCalculateCardinalMoves().size()); // rookMove movimientos
        assertEquals(4,((CompositeMove)kingOrQueenMove.getCalculateCardinalMoves()
                .get(1)).getCalculateCardinalMoves().size()); // bishopMove movimientos

        assertArrayEquals(rookMove.getCalculateCardinalMoves().toArray(),((CompositeMove)kingOrQueenMove
                .getCalculateCardinalMoves().get(0)).getCalculateCardinalMoves().toArray());

        assertArrayEquals(bishopMove.getCalculateCardinalMoves().toArray(),((CompositeMove)kingOrQueenMove
                .getCalculateCardinalMoves().get(1)).getCalculateCardinalMoves().toArray());
    }
}