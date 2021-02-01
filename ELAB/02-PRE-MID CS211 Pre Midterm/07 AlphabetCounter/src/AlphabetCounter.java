//elab-source:AlphabetCounter.java

public class AlphabetCounter {
    private String text = "";

    void addSentence(String sentence){
        text += sentence;
    }

    int countAlphabet(char ch){
        int count = 0;
        for(int i=0; i<text.length(); i++){
            if(Character.toLowerCase(text.charAt(i))==Character.toLowerCase(ch)){count++;}
        }
        return count;
    }
}
