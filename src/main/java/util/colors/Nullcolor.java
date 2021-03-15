package util.colors;

import util.Color;
import util.ColorOfPiece;

public class Nullcolor implements Color {
    String PATH = "/ChessImages";
    String pieceType;

    public Nullcolor(String pieceType){
        this.pieceType = pieceType;
    }

    @Override
    public String colorLink(String pieceType) {
        return PATH+"/default-Unassigned.gif";
    }
}
