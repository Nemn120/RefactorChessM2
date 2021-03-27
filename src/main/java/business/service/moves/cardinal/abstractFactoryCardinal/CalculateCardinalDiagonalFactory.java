package business.service.moves.cardinal.abstractFactoryCardinal;


public class CalculateCardinalDiagonalFactory implements ICalculateCardinalFactory{
    @Override
    public Object createMoveCardinal() {
        return new CalculateMoveDiagonal();
    }
}
