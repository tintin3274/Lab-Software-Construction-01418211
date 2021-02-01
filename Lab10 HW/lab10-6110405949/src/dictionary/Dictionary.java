package dictionary;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class Dictionary implements Serializable {
    private HashMap<String, HashSet> dictionary = new HashMap<>();

    public void addVocabulary(String word, Vocabulary vocabulary){
        HashSet<Vocabulary> vocabularyHashSet = dictionary.get(word);
        if(vocabularyHashSet != null){
            vocabularyHashSet.add(vocabulary);
        }
        else {
            vocabularyHashSet = new HashSet<>();
            vocabularyHashSet.add(vocabulary);
            dictionary.put(word, vocabularyHashSet);
        }
    }

    public void removeVocabulary(Vocabulary vocabulary){
        String word = vocabulary.getWord();
        HashSet<Vocabulary> vocabularyHashSet = dictionary.get(word);
        vocabularyHashSet.remove(vocabulary);
        if(vocabularyHashSet.isEmpty()){
            dictionary.remove(word);
        }
    }

    public HashMap<String, HashSet> getDictionary() {
        return dictionary;
    }

//    public void showAllVocabulary(){
//        for(String key : dictionary.keySet()){
//            HashSet<Vocabulary> vocabularyHashSet = (HashSet<Vocabulary>) dictionary.get(key);
//            for(Vocabulary v : vocabularyHashSet){
//                System.out.println(v.getWord()+"|"+v.getPartOfSpeech());
//            }
//        }
//        System.out.println("---------------------------------------------");
//    }

    public String format(MyFormatter format){
        return format.format(dictionary);
    }
}
