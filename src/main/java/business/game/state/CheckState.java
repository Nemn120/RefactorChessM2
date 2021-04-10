package business.game.state;

import gui.board.ChessGameBoard;

import java.awt.Color;

import business.game.ChessGameEngine;
import business.pieces.King;

public class CheckState extends AbstractState {

    private int playerInCheck;

    public CheckState(ChessGameEngine gameEngine,ChessGameBoard board, King king1,King king2,int playerInCheck) {
		super(gameEngine,board,king1,king2);
		this.playerInCheck = playerInCheck;
	}

	@Override
	public int getType() {
		return State.CHECK;
	}

	@Override
	public int getPlayerInCheck() {
		return playerInCheck;
	}

	@Override
	public void update() {
		King king = getKing(playerInCheck);
		this.board.getCell(king.getRow(),king.getColumn()).setBackground(Color.RED);
	}

	@Override
	public void beforeChange(State state){
		if(state.getType() == State.NORMAL){
			this.board.clearColorsOnBoard();
		}
	}
}
