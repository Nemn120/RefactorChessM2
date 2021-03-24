package business.login;

public class LoginUniversityCardAdapter implements Login{

    private  LoginUniversityCard loginUniversityCard;

    public LoginUniversityCardAdapter() {
        this.loginUniversityCard = new LoginUniversityCard();
    }

    @Override
    public boolean loginIn(String username, String password) {
        return loginUniversityCard.loginIn(username);
    }

}
