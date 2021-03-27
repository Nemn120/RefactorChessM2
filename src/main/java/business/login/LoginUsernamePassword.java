package business.login;

public class LoginUsernamePassword implements Login{

    @Override
    public boolean loginIn(String username, String password) {
        if("admin".equals(username) && "123".equals(password)){
            return true;
        }
        return false;
    }
}
