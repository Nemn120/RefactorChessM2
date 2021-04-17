package mockEntity;

import business.DTO.Universitario;
import business.DTO.UniversitarioDTO;
import util.ObjectMapperJSON;

import java.io.IOException;

public class MockEntity {

    private static MockEntity mockEntity;

    private ObjectMapperJSON objectMapperJSON = new ObjectMapperJSON();

    public static MockEntity getInstance(){
        if(mockEntity == null){
            mockEntity = new MockEntity();
        }
        return mockEntity;
    }

    public Universitario getUniversitarioDTO() throws IOException {
        return objectMapperJSON.readObject("src/test/resources/mock/universitario.json",Universitario.class);
    }

}
