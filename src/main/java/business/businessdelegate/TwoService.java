package business.businessdelegate;

import java.sql.*;

public class TwoService implements BusinessService{
    public void doProcessing(Historial historial) {
        System.out.println("Processed Service Two");

        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

        final String USER = "postgres";
        final String PASS = "postgres";

        // finally de manera implicita - cierra recursos de manera automatica
        try (Connection conexion = DriverManager.getConnection(DB_URL, USER, PASS);) {

            System.out.println("BD conectada!");
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM historial");
            //PreparedStatement st = conexion.prepareStatement("SELECT * FROM historial where id=20");

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("alias"));
            }

            rs.close();
            st.close();

        } catch (SQLException e) {

            System.out.println("Exepcion ejecutada: " + e.getMessage());

        }

    }

}
