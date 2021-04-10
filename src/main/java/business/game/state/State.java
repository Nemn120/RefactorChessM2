package business.game.state;

public interface State {

    public static final int NORMAL = 1;
	public static final int CHECK = 2;
	public static final int CHECKMATE = 3;
	public static final int STALEMATE = 4;

    public abstract int getType();
    public abstract int getWinner();
    public abstract int getLoser();
    public abstract int getPlayerInCheck();
    public abstract void update();
    public abstract void changeState(State state);
    public abstract void beforeChange(State state);
}
