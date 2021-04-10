package business.observer;

public class Referee implements Observer{
    private Observable o = null;
    private int deadPieces = 0;
    public Referee(Observable o){
        this.o = o;
    }

    @Override
    public void update() {
        //lógica para ver el arreglo de piezas muertas;
        //System.out.println("nueva ficha muerta");
        this.deadPieces++;
    }

    public int getDeadPieces() {
        return deadPieces;
    }

    public void setDeadPieces(int deadPieces) {
        this.deadPieces = deadPieces;
    }
}
