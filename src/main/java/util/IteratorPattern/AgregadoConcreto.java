package util.IteratorPattern;

import java.util.Vector;

public class AgregadoConcreto implements Agregado{
    protected Vector aDatos = new Vector();

    public AgregadoConcreto(){
        this.llenar();
    }

    @Override
    public Iterador getIterador(){
        return new IteradorConcreto(this);
    }

    public void llenar()
    {
        this.aDatos.add( new String("Bishop") );
        this.aDatos.add( new String("King") );
        this.aDatos.add( new String("Knight") );
        this.aDatos.add( new String("Pawn") );
        this.aDatos.add( new String("Queen") );
        this.aDatos.add( new String("Rook") );
    }
}
