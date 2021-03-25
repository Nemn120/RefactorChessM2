package util.colorFlyWeight;

public class WhiteFlyWeight extends Colors {
    String PATH = "/ChessImages";
    String color = "White";
    String pieceType;
    public static int num;

    public WhiteFlyWeight(){
        num++;
    }

    @Override
    public String colorLink(String pieceType) {
        return PATH+"/"+color+pieceType+".gif";
    }
}
