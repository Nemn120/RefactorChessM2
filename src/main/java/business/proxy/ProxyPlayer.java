package business.proxy;

public class ProxyPlayer implements IPlayer{

    private IPlayer player;
    private int currentPlayer;

    public ProxyPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    @Override
    public int allowPlay() {
        if(currentPlayer == 1){
            player = RealPlayer1.getInstance();
        }
        if(currentPlayer == 2){
            player = RealPlayer2.getInstance();
        }
        return player.allowPlay();
    }
}

