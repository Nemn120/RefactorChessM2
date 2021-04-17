package business.DTO;

import java.util.logging.Logger;

public class UniversitarioMapper implements IUniversitarioMapper{

    Logger logger = Logger.getLogger(UniversitarioMapper.class.getName());

    @Override
    public UniversitarioDTO mapIn(Universitario universitario){
        logger.info("UniversitarioMapper -> mapIn()");
        if(universitario == null){
            return null;
        }
        UniversitarioDTO universitarioDTO = new UniversitarioDTO();
        universitarioDTO.setFullName(
                universitario.getNombres()+" "+universitario.getApellidos());
        universitarioDTO.setCode(universitario.getCodigo());
        return universitarioDTO;
    }
}
