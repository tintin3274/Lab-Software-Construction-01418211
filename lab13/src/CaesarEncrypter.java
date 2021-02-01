public class CaesarEncrypter implements Encrypter{
    private int key;

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public char[] encrypt(char[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = (char)(data[i] + key);
        }
        return data;
    }
}
