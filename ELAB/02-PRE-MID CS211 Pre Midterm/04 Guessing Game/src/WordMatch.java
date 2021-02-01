//elab-source:WordMatch.java

public class WordMatch implements GuessingGame {
    private char answer[];
    private int length;
    private String output;
    private boolean won = false;
    private boolean lost = false;

    @Override
    public void setAnswer(String ans) {
        answer = ans.toCharArray();
        length = ans.length();
    }

    @Override
    public void guess(String s) {
        if(length == s.length()){
            int i;
            int correct = 0;
            char guess[] = s.toCharArray();
            for(i=0; i<length; i++){
                if(Character.toLowerCase(answer[i])==Character.toLowerCase((guess[i]))){
                    correct++;
                }
            }
            if(length == correct){
                won = true;
                output = "";
            }

            else{
                output = "Match "+correct;
            }

        }
        else{
            output = "Length not match";
        }
    }

    @Override
    public String getOutput() {
        return output;
    }

    @Override
    public boolean isWon() {
        return won;
    }

    @Override
    public boolean isLost() {
        return lost;
    }
}
