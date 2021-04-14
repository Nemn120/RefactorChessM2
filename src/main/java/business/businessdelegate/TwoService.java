package business.businessdelegate;

import java.sql.*;

public class TwoService implements BusinessService{

    final String USER = "postgres";
    final String PASS = "postgres";

    public void doProcessing(Historial historial) {

        System.out.println("Processed Service Two");

        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

        // finally de manera implicita - cierra recursos de manera automatica
        try (Connection conexion = DriverManager.getConnection(DB_URL, USER, PASS);) {

            System.out.println("BD conectada!");
            //PreparedStatement st = conexion.prepareStatement("SELECT * FROM historial");
            //PreparedStatement st = conexion.prepareStatement("SELECT * FROM historial where id=20");
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM historial where alias=?");
            st.setString(1, historial.getAlias());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
               // System.out.println(rs.getInt("id") + " " + rs.getString("alias"));
                System.out.println(rs.getString("alias")+":\n"+rs.getString("texto"));
            }

            rs.close();
            st.close();

        } catch (SQLException e) {

            System.out.println("Exepcion ejecutada: " + e.getMessage());

        }

    }

}
