package business.login;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginUsernamePasswordTest {

    Login login;

    @BeforeEach
    void setUp() {
        login=new LoginUsernamePassword();
    }

    @Test
    public void loginIn() {

        Assert.assertTrue(login.loginIn("admin","123"));

        Assert.assertFalse(login.loginIn("123","admin"));

        Assert.assertFalse(login.loginIn("",""));

        Assert.assertFalse(login.loginIn(null,"admin"));

        Assert.assertFalse(login.loginIn("admin",null));

        Assert.assertFalse(login.loginIn(" "," "));

        Assert.assertFalse(login.loginIn(null,null));

    }

}