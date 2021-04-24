package business.DTO.DAO;

import business.DTO.Universitario;

import java.util.List;

public interface DAOUniversitario {
    void registrar(Universitario u);
    Universitario buscar(String codigo);
}
