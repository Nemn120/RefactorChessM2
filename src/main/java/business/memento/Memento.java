package business.memento;

import gui.board.BoardSquare;

public class Memento {

    private BoardSquare[][] estado;
    private int currentPlayer;

    public Memento(BoardSquare[][] estado,int currentPlayer) {
        this.estado = estado;
        this.currentPlayer = currentPlayer;
    }

    public BoardSquare[][] getEstado() {
        return estado;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

}
