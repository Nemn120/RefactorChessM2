package util;

import util.colorFlyWeight.ColorFactoryFlyWeight;
import util.colorFlyWeight.Colors;

public class ResourceOfPiece implements IResourceOfPiece{

    private Colors colors;

    public ResourceOfPiece(int pieceColor){
        colors = ColorFactoryFlyWeight.getColor(pieceColor);
    }

    @Override
    public String resourceByType(String pieceType){
        return colors.colorLink(pieceType);
    }

}
