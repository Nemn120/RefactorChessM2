package business.game.state;

import business.game.ChessGameEngine;

public class NormalState extends AbstractState {
    
    public NormalState(ChessGameEngine gameEngine) {
		super(gameEngine);
	}

	@Override
	public int getStateName() {
		return State.NORMAL;
	}

}
