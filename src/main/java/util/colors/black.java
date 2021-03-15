package util.colors;

import util.Color;
import util.ColorOfPiece;

public class black implements Color {
    String PATH = "/ChessImages";
    String color = "Black";
    String pieceType;

    public black(String pieceType){
        this.pieceType = pieceType;
    }

    @Override
    public String colorLink(String pieceType) {
        return PATH+"/"+color+pieceType+".gif";
    }

}
