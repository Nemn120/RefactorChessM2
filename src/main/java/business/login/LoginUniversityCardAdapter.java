package business.login;

public class LoginUniversityCardAdapter implements Login{

    private  LoginUniversityCard loginUniversityCard;

    @Override
    public boolean loginIn(String username, String password) {
        return loginUniversityCard.loginIn(username);
    }

}
