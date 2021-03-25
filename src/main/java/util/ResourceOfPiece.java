package util;

import util.colorFlyWeight.ColorFactoryFlyWeight;
import util.colorFlyWeight.Colors;

public class ResourceOfPiece implements IResourceOfPiece{

    //int color;
    private Colors colors;

    public ResourceOfPiece(int pieceColor){
        //this.color = pieceColor;
        colors = ColorFactoryFlyWeight.getColor(pieceColor);
    }

    @Override
    public String resourceByType(String pieceType){
        return colors.colorLink(pieceType);
    }
    /*
    @Override
    public String resourceByType(String pieceType) {
        String colorType;
        if ( color == ColorOfPiece.WHITE ){
            colorType = "White";
        }
        else if ( color == ColorOfPiece.BLACK ){
            colorType = "Black";
        }
        else
        {
            colorType = "Nullcolor";
        }
        Color color = Colorfactory.createColor(colorType);
        return color.colorLink(pieceType);
    }
     */

}
