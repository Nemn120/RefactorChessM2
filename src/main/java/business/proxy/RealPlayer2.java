package business.proxy;

public class RealPlayer2 implements IPlayer{
    private int currentPlayer;
    private static RealPlayer2 instance;

    public RealPlayer2() {

    }

    @Override
    public int allowPlay() {
        return 2;
    }

    public static RealPlayer2 getInstance(){
        if(instance == null){
            instance = new RealPlayer2();
        }
        return instance;
    }
}
