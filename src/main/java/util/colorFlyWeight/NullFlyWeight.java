package util.colorFlyWeight;

public class NullFlyWeight extends Colors {
    String PATH = "/ChessImages";
    String pieceType;
    public static int num;

    public NullFlyWeight(){
        num++;
    }

    @Override
    public String colorLink(String pieceType) {
        return PATH+"/default-Unassigned.gif";
    }
}
