//elab-source: DigitValidator.java

import java.util.regex.Pattern;

public class DigitValidator implements PasswordValidator {
    @Override
    public boolean validate(String password) {
        return (Pattern.compile("[0-9]").matcher(password).find() && password.length()>=6);
    }
}
