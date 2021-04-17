package business.DTO.DAO;

import business.DTO.Universitario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOUniversitarioImp  implements DAOUniversitario{

    final String USER = "postgres";
    final String PASS = "postgres";

    public void registrar(Universitario u) throws Exception {



    }

    public List<Universitario> listar() throws Exception {
       return null;
    }

    public Universitario buscar(String code) {

        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        try (Connection connexion = DriverManager.getConnection(DB_URL, USER, PASS);) {
            System.out.println("BD conectada!");
            PreparedStatement st = connexion.prepareStatement("SELECT * FROM universitario where code=?");
            st.setString(1, code);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("code") + ":\n" + rs.getString("nombres"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Exception ejecutada: " + e.getMessage());
        }
        return null;
    }

}
