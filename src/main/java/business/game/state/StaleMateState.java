package business.game.state;

import business.game.ChessGameEngine;

public class StaleMateState extends AbstractState {

    public StaleMateState(ChessGameEngine gameEngine) {
		super(gameEngine);
	}

	@Override
	public int getStateName() {
		return State.STALEMATE;
	}

}
