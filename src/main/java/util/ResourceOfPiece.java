package util;

import util.colors.blackcolor;
import util.colors.nullcolor;
import util.colors.whitecolor;
import util.colorFactory.colorfactory;

public class ResourceOfPiece implements IResourceOfPiece{

    int color;

    public ResourceOfPiece(int pieceColor){
        this.color = pieceColor;
    }

    @Override
    public String resourceByType(String pieceType) {
        String colorType;
        if ( color == ColorOfPiece.WHITE ){
            colorType = "whitecolor";

        }
        else if ( color == ColorOfPiece.BLACK ){
            colorType = "blackcolor";
        }
        else
        {
            colorType = "nullcolor";
        }
        Color color = colorfactory.createColor(colorType);
        return color.colorLink(pieceType);
    }
    
}
