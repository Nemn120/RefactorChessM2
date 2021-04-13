package business.businessdelegate;

public class Historial {

    private int id;
    private String alias;
    private String texto;

    public Historial(int id) {
        this.id = id;
    }

    public Historial(String alias, String texto) {
        this.alias = alias;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
