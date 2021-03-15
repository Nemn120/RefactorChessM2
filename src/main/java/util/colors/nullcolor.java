package util.colors;

import util.Color;
import util.ColorOfPiece;

public class nullcolor implements Color {
    String PATH = "/ChessImages";
    String pieceType;

    public nullcolor(String pieceType){
        this.pieceType = pieceType;
    }

    @Override
    public String colorLink(String pieceType) {
        return PATH+"/default-Unassigned.gif";
    }
}
