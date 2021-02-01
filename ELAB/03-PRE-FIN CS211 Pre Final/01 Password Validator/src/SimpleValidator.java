//elab-source: SimpleValidator.java

public class SimpleValidator implements PasswordValidator {
    @Override
    public boolean validate(String password) {
        return (password.length() >= 4);
    }
}
