package util.colors;

import util.Color;
import util.ColorOfPiece;

public class white implements Color {
    String PATH = "/ChessImages";
    String color = "White";
    String pieceType;

    public white(String pieceType){
        this.pieceType = pieceType;
    }

    @Override
    public String colorLink(String pieceType) {
        return PATH+"/"+color+pieceType+".gif";
    }
}
