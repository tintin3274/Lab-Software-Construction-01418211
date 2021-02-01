//elab-source:Dictionary.java

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, Vocabulary> dictionary = new HashMap<>();

    public void add(Vocabulary vocab){
        if(vocab != null) dictionary.put(vocab.getName(), vocab);
    }

    public String search(String vocab){
        Vocabulary vocabulary = dictionary.get(vocab);
        if(vocabulary != null) return vocabulary.toString();
        return "Not found \"" + vocab + "\" in Dictionary.";

    }

    public int getSize(){
        return dictionary.size();
    }
}
