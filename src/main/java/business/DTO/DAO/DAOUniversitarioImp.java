package business.DTO.DAO;

import business.DTO.Universitario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOUniversitarioImp extends Conexion implements DAOUniversitario{

    public void registrar(Universitario u) throws Exception {

        try {
            this.conectar();
            PreparedStatement ps=this.conexion.prepareStatement("INSERT INTO persona(nombre) VALUES(?)");
            //ps.setString(1, p.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }

    }

    public List<Universitario> listar() throws Exception {
        List<Universitario> lista;
        try {
            this.conectar();
            PreparedStatement ps=this.conexion.prepareStatement("SELECT * FROM persona");
            ResultSet rs= ps.executeQuery();
            lista=new ArrayList<>();
            while (rs.next()) {
                //lista.add(new Persona(rs.getInt("id"), rs.getString("nombre")));
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return lista;
    }
}
