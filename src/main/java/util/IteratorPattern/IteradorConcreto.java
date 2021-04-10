package util.IteratorPattern;

public class IteradorConcreto implements Iterador{
    private AgregadoConcreto agregado;
    private int posicion_actual = 0;
    // -------------------------
    public IteradorConcreto( AgregadoConcreto agregado )
    {
        this.agregado = agregado;
    }
    // -------------------------
    @Override
    public Object first()
    {
        Object obj = null;
        if( this.agregado.aDatos.isEmpty() == false )
        {
            this.posicion_actual = 0;
            obj = this.agregado.aDatos.firstElement();
        }
        return obj;
    }
    // -------------------------
    @Override
    public Object next()
    {
        Object obj = null;
        if( (this.posicion_actual ) < this.agregado.aDatos.size() )
        {
            obj = this.agregado.aDatos.elementAt(this.posicion_actual);
            this.posicion_actual = this.posicion_actual + 1;
        }
        return obj;
    }
    // -------------------------
    @Override
    public boolean hasNext()
    {
        boolean ok = false;
        if( this.posicion_actual < (this.agregado.aDatos.size() ) )
        {
            ok = true;
        }
        return ok;
    }
    // -------------------------
    @Override
    public Object actual()
    {
        Object obj = null;
        if( this.posicion_actual < this.agregado.aDatos.size() )
        {
            obj = this.agregado.aDatos.elementAt( this.posicion_actual );
        }
        return obj;
    }
}
