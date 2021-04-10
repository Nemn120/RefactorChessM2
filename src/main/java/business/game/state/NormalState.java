package business.game.state;

import business.game.ChessGameEngine;
import business.pieces.King;
import gui.board.ChessGameBoard;

public class NormalState extends AbstractState {
    
    public NormalState(ChessGameEngine gameEngine,ChessGameBoard board,King king1,King king2) {
		super(gameEngine,board,king1,king2);
	}

	@Override
	public int getType() {
		return State.NORMAL;
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
