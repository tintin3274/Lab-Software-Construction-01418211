public class Main2 {
    public static void main(String[] args) {
        Email email1 = new Email("Kwan", "Kate", "Hello");
        Email email2 = new Email("George", "Ken", "Hi");

        EmailSystem emailSystem = new EmailSystem();

        //emailSystem.sendCaesar(email1, 2);
        //emailSystem.sendSwitchCipher(email2);

        emailSystem.setEncrypter(new SwitchCipherEncrypter());
        emailSystem.send(email2);
        System.out.println(emailSystem);

        CaesarEncrypter caesarEncrypter = new CaesarEncrypter();
        caesarEncrypter.setKey(2);
        emailSystem.setEncrypter(caesarEncrypter);
        emailSystem.send(email1);
        System.out.println(emailSystem);
    }
}
