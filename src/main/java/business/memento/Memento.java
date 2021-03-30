package business.memento;

import gui.board.BoardSquare;

public class Memento {

    private BoardSquare[][] estado;

    public Memento(BoardSquare[][] estado) {
        this.estado = estado;
    }

    public BoardSquare[][] getEstado() {
        return estado;
    }

}
