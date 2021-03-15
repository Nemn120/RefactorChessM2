package util.colors;

import util.Color;

public class Black implements Color {
    String PATH = "/ChessImages";
    String color = "Black";
    String pieceType;

    public Black(String pieceType){
        this.pieceType = pieceType;
    }

    @Override
    public String colorLink(String pieceType) {
        return PATH+"/"+color+pieceType+".gif";
    }

}
