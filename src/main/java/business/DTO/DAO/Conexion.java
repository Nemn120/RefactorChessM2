package business.DTO.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    protected Connection conexion = null;
    private final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER = "postgres";
    private final String PASS = "postgres";

    public void conectar() throws SQLException {

        try {
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            throw e;
        }

    }

    public void cerrar() throws SQLException {

        if (conexion != null) {
            try {
                if (!conexion.isClosed()) {
                    conexion.close();
                }
            } catch (SQLException e) {
                throw e;
            }

        }

    }
}
