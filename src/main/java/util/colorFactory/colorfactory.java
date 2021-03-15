package util.colorFactory;

import util.Color;
import util.colors.black;
import util.colors.nullcolor;
import util.colors.white;

public class colorfactory {
    public static Color createColor(String pieceType){
        Color color = null;
        if("black".equalsIgnoreCase(pieceType)){
            color = new black(pieceType);
        }
        else if("white".equalsIgnoreCase(pieceType)){
            color = new white(pieceType);
        }
        else{
            color = new nullcolor(pieceType);
        }
        return color;
    }
}
