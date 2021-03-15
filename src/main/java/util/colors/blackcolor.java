package util.colors;

import util.Color;
import util.ColorOfPiece;

public class blackcolor implements Color {
    String PATH = "/ChessImages";
    String color = "Black";
    String pieceType;

    public blackcolor(String pieceType){
        this.pieceType = pieceType;
    }

    @Override
    public String colorLink(String pieceType) {
        return PATH+"/"+color+pieceType+".gif";
    }

}
