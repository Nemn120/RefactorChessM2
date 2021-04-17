package business.DTO;

import mockEntity.MockEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class UniversitarioMapperTest {

    IUniversitarioMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new UniversitarioMapper();
    }

    @Test
    void mapInFullTest() throws IOException {
        Universitario universitario = MockEntity.getInstance().getUniversitario();
        UniversitarioDTO universitarioDTO = mapper.mapIn(universitario);

        assertNotNull(universitarioDTO);
        assertNotNull(universitarioDTO.getFullName());
        assertNotNull(universitarioDTO.getCode());

        assertEquals(universitario.getCodigo(),universitarioDTO.getCode());
        String nombreCompleto = universitario.getNombres()+" "+universitario.getApellidos();
        assertEquals(nombreCompleto,universitarioDTO.getFullName());

    }


}
