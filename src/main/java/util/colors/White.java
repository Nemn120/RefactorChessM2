package util.colors;

import util.Color;

public class White implements Color  {
    String PATH = "/ChessImages";
    String color = "White";
    String pieceType;
    public static int num;

    public White(String pieceType){
        this.pieceType = pieceType;
        num++;
    }

    @Override
    public String colorLink(String pieceType) {
        return PATH+"/"+color+pieceType+".gif";
    }
}
