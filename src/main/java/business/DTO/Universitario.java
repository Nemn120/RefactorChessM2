package business.DTO;

public class Universitario {
    private int id;
    private String nombres;
    private String apellidos;
    private String dni;
    private String escuela;
    private String codigo;

    public Universitario() {
    }

    public Universitario(String codigo) {
        this.codigo = codigo;
    }

    public Universitario(String nombres, String apellidos, String dni, String escuela, String codigo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.escuela = escuela;
        this.codigo = codigo;
    }

    public Universitario(int id, String nombres, String apellidos, String dni, String escuela, String codigo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.escuela = escuela;
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Universitario{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                ", escuela='" + escuela + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
