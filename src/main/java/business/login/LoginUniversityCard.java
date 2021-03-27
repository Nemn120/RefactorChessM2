package business.login;

import util.university.Credential;

public class LoginUniversityCard {

    public boolean loginIn(String universityCard) {
        if(Credential.CODE.containsKey(universityCard)){
            return true;
        }
        return false;
    }

}
