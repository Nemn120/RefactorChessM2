package business.businessdelegate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BusinessDelegatePatternTest {

    BusinessDelegate businessDelegate;

    @BeforeEach
    public void before(){
        businessDelegate = new BusinessDelegate();
    }

    @Test
    void testBusinessDelegate() {
        BusinessService bs=businessDelegate.getLookupService().getBusinessService("One");
        if( bs instanceof OneService){
            assertTrue(true,"Servicio One");
        }else {
            fail("Error");
        }
        bs=businessDelegate.getLookupService().getBusinessService("Two");
        if(bs instanceof TwoService){
            assertTrue(true,"Servicio Two");
        }else {
            fail("Error");
        }
    }
}