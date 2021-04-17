package business.DTO.DAO;

import business.DTO.Universitario;

import java.util.List;

public interface DAOUniversitario {
    public void registrar(Universitario u);
    public List<Universitario> listar();
    public Universitario buscar(String codigo);
}
