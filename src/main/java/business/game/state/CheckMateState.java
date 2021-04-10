package business.game.state;

import business.game.ChessGameEngine;
import business.pieces.King;
import gui.board.ChessGameBoard;

public class CheckMateState extends AbstractState {

	private int loser;
    
    public CheckMateState(ChessGameEngine gameEngine,ChessGameBoard board,King king1,King king2,int loser) {
		super(gameEngine,board,king1,king2);
		this.loser = loser;
	}

	@Override
	public int getType() {
		return State.CHECKMATE;
	}

	@Override
	public int getWinner() {
		return loser == 1 ? 2 : 1;
	}

	@Override
	public int getLoser() {
		return loser;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChange(State state) {
		// TODO Auto-generated method stub
		
	}

}
