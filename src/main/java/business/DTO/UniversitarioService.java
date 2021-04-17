package business.DTO;

import business.DTO.DAO.DAOUniversitario;
import business.DTO.DAO.DAOUniversitarioImp;

public class UniversitarioService {

    DAOUniversitario universitarioDao;
    IUniversitarioMapper universitarioMapper;

    public UniversitarioService() {
        this.universitarioDao = new DAOUniversitarioImp();
        this.universitarioMapper = new UniversitarioMapper();
    }

    public void guardarUsuario(Universitario u){
        universitarioDao.registrar(u);
    }

    public UniversitarioDTO createDTO(String code) {
        if(code == null){
            return null;
        }
        Universitario universitario=universitarioDao.buscar(code);
        UniversitarioDTO universitarioDTO =universitarioMapper.mapIn(universitario);

        if(universitarioDTO != null){
            System.out.println("UniversitarioDTO: "+universitarioDTO.toString());
        }else{
            System.out.println("UniversitarioDTO: No existe");
        }
        return universitarioDTO;
    }
}
