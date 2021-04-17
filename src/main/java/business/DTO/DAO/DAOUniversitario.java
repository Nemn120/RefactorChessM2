package business.DTO.DAO;

import business.DTO.Universitario;

import java.util.List;

public interface DAOUniversitario {
    public void registrar(Universitario u) throws Exception;
    public List<Universitario> listar() throws Exception;

    public Universitario buscar(String codigo);
}
