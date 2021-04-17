package business.DTO;

import business.DTO.DAO.DAOUniversitario;
import business.DTO.DAO.DAOUniversitarioImp;

public class UniversitarioService {

    public UniversitarioDTO createDTO(Universitario universitario) {
        UniversitarioDTO dto=null;

        //metodo para buscar
        DAOUniversitario dao=new DAOUniversitarioImp();
        Universitario universitarioBD=dao.buscar(universitario.getCodigo());

        //Create dto
        if(universitarioBD!=null){
            dto = new UniversitarioDTO();
            dto.setFullName(universitarioBD.getNombres() + " " + universitarioBD.getApellidos());
            dto.setCode(universitarioBD.getCodigo());
            System.out.println("UniversitarioDTO: "+dto.toString());
        }else{
            System.out.println("UniversitarioDTO: No existe");
        }

        //Return DTO
        return dto;

    }

}
