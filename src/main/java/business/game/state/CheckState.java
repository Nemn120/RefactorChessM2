package business.game.state;

import business.game.ChessGameEngine;

public class CheckState extends AbstractState {

    int playerInCheck;

    public CheckState(ChessGameEngine gameEngine, int playerInCheck) {
		super(gameEngine);
		this.playerInCheck = playerInCheck;
	}

	@Override
	public int getStateName() {
		return State.CHECK;
	}

	@Override
	public int getPlayer() {
		return playerInCheck;
	}

}
