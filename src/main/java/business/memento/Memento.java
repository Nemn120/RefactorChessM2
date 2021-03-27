package business.memento;

import business.game.ChessGameEngine;

public class Memento {

    private ChessGameEngine estado;

    public Memento(ChessGameEngine estado) {
        this.estado = estado;
    }

    public ChessGameEngine getEstado() {
        return estado;
    }

}
