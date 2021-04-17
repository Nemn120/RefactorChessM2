package business.DTO;

public class UniversitarioService {

    private UniversitarioDTO createDTO(Universitario universitario) {

        //metodo para buscar

        //Create dto
        UniversitarioDTO dto = new UniversitarioDTO();
        dto.setFullName(universitario.getNombres() + " " + universitario.getApellidos());
        dto.setCode(universitario.getCode());

        //Return DTO
        return dto;

    }

}
