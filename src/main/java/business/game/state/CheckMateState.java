package business.game.state;

import business.game.ChessGameEngine;

public class CheckMateState extends AbstractState {

	int lostPlayer;
    
    public CheckMateState(ChessGameEngine gameEngine,int lostPlayer) {
		super(gameEngine);
		this.lostPlayer = lostPlayer;
	}

	@Override
	public int getStateName() {
		return State.CHECKMATE;
	}

	@Override
	public int getPlayer() {
		return lostPlayer;
	}

}
