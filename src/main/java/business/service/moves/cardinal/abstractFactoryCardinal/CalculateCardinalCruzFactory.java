package business.service.moves.cardinal.abstractFactoryCardinal;

public class CalculateCardinalCruzFactory implements ICalculateCardinalFactory{
    @Override
    public Object createMoveCardinal() {
        return new CalculateMoveCruz();
    }
}
