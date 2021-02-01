//elab-source: RegistrationSystem.java

import java.util.ArrayList;

public class RegistrationSystem {
    private ArrayList<User> userList = new ArrayList<>();

    private PasswordValidator validator;

    public void setPasswordValidator(PasswordValidator validator){
        this.validator = validator;
    }

    public boolean register(String username, String password) {
        if(validator.validate(password)){
            userList.add(new User(username, password));
            return true;
        }
        return false;
    }

    public ArrayList<User> getUsers() {
        return userList;
    }
}
