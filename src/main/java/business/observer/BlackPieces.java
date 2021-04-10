package business.observer;

import business.pieces.ChessGamePiece;

import java.util.ArrayList;
import java.util.List;

public class BlackPieces implements Observable{
    private List<Observer> subscribers = new ArrayList<Observer>();
    private List<ChessGamePiece> deadPieces = new ArrayList<ChessGamePiece>();

    @Override
    public void attach(Observer o) {
        this.subscribers.add(o);
    }

    @Override
    public void detach(Observer o) {

    }

    public void addNewDeadPiece(ChessGamePiece piece){
        this.deadPieces.add(piece);
        this._notify();
        System.out.println("nueva pieza negra muerta" + piece.toString());

    }

    @Override
    public void _notify() {
        subscribers.forEach(subscriptor->{
            subscriptor.update();
        });
    }
}
