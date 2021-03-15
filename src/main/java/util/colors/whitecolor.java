package util.colors;

import util.Color;
import util.ColorOfPiece;

public class whitecolor implements Color {
    String PATH = "/ChessImages";
    String color = "White";
    String pieceType;

    public whitecolor(String pieceType){
        this.pieceType = pieceType;
    }

    @Override
    public String colorLink(String pieceType) {
        return PATH+"/"+color+pieceType+".gif";
    }
}
