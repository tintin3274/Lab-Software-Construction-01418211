import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmailSystem {
    private HashMap<String, List<Email>> mailboxes;
    private Encrypter encrypter;

    public EmailSystem() {
        mailboxes = new HashMap<>();
    }

    public void send(Email m) {
        // encrypt
        char[] data = m.getText().toCharArray();
        data = encrypter.encrypt(data);
        m.setText(new String(data));
        // deliver to corresponding mailbox
        List<Email> box = mailboxes.get(m.getRecipient());
        if (box == null) {
            box = new ArrayList<>();
        }
        box.add(m);
        mailboxes.put(m.getRecipient(), box);
    }

    public void setEncrypter(Encrypter encrypter) {
        this.encrypter = encrypter;
    }

    @Override
    public String toString() {
        return "EmailSystem{" +
                "mailboxes=" + mailboxes +
                '}';
    }

    public void sendCaesar(Email m, int key) {
        // encrypt
        char[] data = m.getText().toCharArray();
        for (int i = 0; i < data.length; i++) {
            data[i] = (char)(data[i] + key);
        }
        m.setText(new String(data));
        // deliver to corresponding mailbox
        List<Email> box = mailboxes.get(m.getRecipient());
        box.add(m);
    }
    public void sendSwitchCipher(Email m) {
        // encrypt
        char[] data = m.getText().toCharArray();
        for (int i = 0; i < data.length-1; i += 2) {
            char tmp = data[i];
            data[i] = data[i+1];
            data[i+1] = tmp;
        }
        m.setText(new String(data));
        // deliver to corresponding mailbox
        List<Email> box = mailboxes.get(m.getRecipient());
        box.add(m);
    }
}
