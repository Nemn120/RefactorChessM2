package util.colorFlyWeight;

public class UndefinedFlyWeight extends Colors {
    String PATH = "/ChessImages";
    String pieceType;
    public static int num;

    public UndefinedFlyWeight(){
        num++;
    }

    @Override
    public String colorLink(String pieceType) {
        return PATH+"/default-Unassigned.gif";
    }
}
