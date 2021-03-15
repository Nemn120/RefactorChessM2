package util.colorFactory;

import util.Color;
import util.colors.blackcolor;
import util.colors.nullcolor;
import util.colors.whitecolor;

public class colorfactory {
    public static Color createColor(String pieceType){
        Color color = null;
        if("blackcolor".equalsIgnoreCase(pieceType)){
            color = new blackcolor(pieceType);
        }
        else if("whitecolor".equalsIgnoreCase(pieceType)){
            color = new whitecolor(pieceType);
        }
        else{
            color = new nullcolor(pieceType);
        }
        return color;
    }
}
