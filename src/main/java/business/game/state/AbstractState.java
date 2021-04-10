package business.game.state;

import business.game.ChessGameEngine;
import business.pieces.King;
import gui.board.ChessGameBoard;

public abstract class AbstractState implements State {

	protected ChessGameEngine gameEngine;
    protected ChessGameBoard board;
	protected King king1;
	protected King king2;

    public AbstractState(ChessGameEngine gameEngine,ChessGameBoard board,King king1,King king2) {
		this.gameEngine = gameEngine;
		this.board = board;
		this.king1 = king1;
		this.king2 = king2;
	}

	public King getKing(int player){
		return  player == 1 ? king1 : king2;
	}

	@Override
	public int getWinner() {
		return 0;
	}

	@Override
	public int getLoser() {
		return 0;
	}

	@Override
    public int getPlayerInCheck() {
		return 0;
	}

	@Override
	public void changeState(State state) {
		beforeChange(state);
		gameEngine.setState(state);
	}

	public abstract void beforeChange(State state);
}
