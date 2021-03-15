package business.service.king;


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KingServiceTest {


    @Test
    public void kingServiceSingletonTest(){
        KingService x = KingService.getInstance(null,null);
        KingService y = KingService.getInstance(null,null);
        assertEquals(x,y);
    }

}