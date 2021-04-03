package business.game.state;

import business.game.ChessGameEngine;

public abstract class AbstractState implements State {

    private ChessGameEngine gameEngine;

    public AbstractState(ChessGameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}

    public ChessGameEngine getGameEngine() {
		return gameEngine;
	}

	@Override
	public int getPlayer() {
		return 0;
	}
	
}
