package business.DTO.DAO;

import business.DTO.Universitario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOUniversitarioImp  implements DAOUniversitario{

    final String USER = "postgres";
    final String PASS = "postgres";

    public void registrar(Universitario u) {

        System.out.println("Guardando Universitario!");
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        try (Connection connexion = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("BD conectada!");
            PreparedStatement st = connexion.prepareStatement(
                    "INSERT INTO universitario(nombres,apellidos,dni,escuela,codigo) VALUES (?,?,?,?,?)");
            st.setString(1, u.getNombres());
            st.setString(2, u.getApellidos());
            st.setString(1, u.getDni());
            st.setString(2, u.getEscuela());
            st.setString(1, u.getCodigo());

            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.err.println("Exception ejecutada:");
            e.printStackTrace();
        }

    }

    public List<Universitario> listar(){
       return null;
    }

    public Universitario buscar(String codigo) {

        System.out.println("Buscando Universitario!");
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        Universitario universitarioBD=null;
        try (Connection connexion = DriverManager.getConnection(DB_URL, USER, PASS);) {
            System.out.println("BD conectada!");
            PreparedStatement st = connexion.prepareStatement("SELECT * FROM universitario where codigo=?");
            st.setString(1, codigo);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                universitarioBD=new Universitario(rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("dni"),
                        rs.getString("escuela"),
                        rs.getString("codigo"));
                System.out.println("Universitario: "+universitarioBD.toString());
            }
            if(universitarioBD==null){
                System.out.println("Universitario: No existe");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Exception ejecutada: " + e.getMessage());
        }
        return universitarioBD;
    }

}
