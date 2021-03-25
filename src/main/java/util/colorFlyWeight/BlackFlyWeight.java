package util.colorFlyWeight;

public class BlackFlyWeight extends Colors {
    String PATH = "/ChessImages";
    String color = "Black";
    String pieceType;
    public static int num;

    public BlackFlyWeight(){
        num++;
    }

    @Override
    public String colorLink(String pieceType) {
        return PATH+"/"+color+pieceType+".gif";
    }

}
