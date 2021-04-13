package business.businessdelegate;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class OneService implements BusinessService{

    final String USER = "postgres";
    final String PASS = "postgres";

    Connection conexion = null;

    public void doProcessing(String historial)
    {
        System.out.println("Processed Service One");

        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

        try (Connection conexion = DriverManager.getConnection(DB_URL, USER, PASS)) {

            System.out.println("BD conectada!");
           // PreparedStatement st = conexion.prepareStatement(
                 //   "INSERT INTO ajedrez(alias,historial) VALUES ('Juan',historial)");
            PreparedStatement st = conexion.prepareStatement("INSERT INTO ajedrez(alias,historial) VALUES (?,?)");
            st.setString(1, "uno");
            st.setString(2, historial);
            st.executeUpdate();
            st.close();
        } catch (SQLException throwables) {
            System.out.println("Catch ejecutado");
            throwables.printStackTrace();

        }

    }

}
