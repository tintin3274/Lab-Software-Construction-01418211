//elab-source: Note.java

public class Note {
    private char key;
    private int length;

    public Note(char key, int length) {
        this.key = key;
        this.length = length;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public String playNote(){
        String note = "";
        for (int i = 0; i<length; i++){
            note += key;
        }
        return note;
    }
}
