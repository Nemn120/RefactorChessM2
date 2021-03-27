package business.memento;

import business.game.ChessGameEngine;

public class Originator {

    private ChessGameEngine estado;

    public void setEstado(ChessGameEngine estado) {
        this.estado = estado;
    }

    public ChessGameEngine getEstado() {
        return estado;
    }

    public Memento guardar() {
        return new Memento(estado);
    }

    public void restaurar(Memento m) {
        this.estado = m.getEstado();
    }

}
