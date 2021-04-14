package business.businessdelegate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class OneService implements BusinessService{
    final String USER = "postgres";
    final String PASS = "postgres";
    public void doProcessing(Historial historial)
    {
        System.out.println("Processed Service One");
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        try (Connection connexion = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("BD conectada!");
            PreparedStatement st = connexion.prepareStatement("INSERT INTO historial(alias,texto) VALUES (?,?)");
            st.setString(1, historial.getAlias());
            st.setString(2, historial.getTexto());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.err.println("Exception ejecutada:");
            e.printStackTrace();
        }
    }
}
