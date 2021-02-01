//elab-source: CreativeNote.java

public class CreativeNote extends Note {

    public CreativeNote(char key, int length) {
        super((char) (key-1), length);
    }

    @Override
    public String playNote() {
        setKey((char) (getKey()+1));
        if(getKey() > 'G') setKey('A');
        return super.playNote();
    }
}
