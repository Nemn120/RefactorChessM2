package util;

import util.colorFactory.Colorfactory;

public class ResourceOfPiece implements IResourceOfPiece{

    int color;

    public ResourceOfPiece(int pieceColor){
        this.color = pieceColor;
    }

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
    
}
