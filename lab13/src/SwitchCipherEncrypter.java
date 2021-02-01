public class SwitchCipherEncrypter implements Encrypter {
    @Override
    public char[] encrypt(char[] data) {
        for (int i = 0; i < data.length-1; i += 2) {
            char tmp = data[i];
            data[i] = data[i+1];
            data[i+1] = tmp;
        }
        return data;
    }
}
