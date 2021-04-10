package business.proxy;

public class RealPlayer1 implements IPlayer{
    private int currentPlayer;
    private static RealPlayer1 instance;

    public RealPlayer1() {

    }

    @Override
    public int allowPlay() {
        return 1;
    }

    public static RealPlayer1 getInstance(){
        if(instance == null){
            instance = new RealPlayer1();
        }
        return instance;
    }
}
