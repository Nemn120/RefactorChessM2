package business.login;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginUniversityCardAdapterTest {

    Login login;

    @BeforeEach
    void setUp() {
        login=new LoginUniversityCardAdapter();
    }

    @Test
    public void loginIn() {

        Assert.assertTrue(login.loginIn("17200320",""));

        Assert.assertFalse(login.loginIn("","17200320"));

        Assert.assertFalse(login.loginIn("",""));

        Assert.assertFalse(login.loginIn(null,"admin"));

        Assert.assertFalse(login.loginIn("admin",null));

        Assert.assertFalse(login.loginIn(" "," "));

        Assert.assertFalse(login.loginIn(null,null));

    }

}

