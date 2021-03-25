package util.colors;

import util.Color;

public class Nullcolor implements Color {
    String PATH = "/ChessImages";
    String pieceType;
    public static int num;

    public Nullcolor(String pieceType){
        this.pieceType = pieceType;
        num++;
    }

    @Override
    public String colorLink(String pieceType) {
        return PATH+"/default-Unassigned.gif";
    }
}
