//elab-source:Hangman.java

public class Hangman implements GuessingGame{
    private char answer[];
    private char result[];
    private int length;
    private int correct;
    private int life;
    private String output;
    private boolean won = false;
    private boolean lost = false;

    @Override
    public void setAnswer(String ans) {
        answer = ans.toLowerCase().toCharArray();
        length = ans.length();
        correct = 0;
        life = 6;
        result = new char[length];
        for(int i=0; i<length ;i++){
            result[i] = '_';
        }
    }

    @Override
    public void guess(String s) {
        if(s.length() > 1){
            output = "One character only";
        }
        else{
            if(new String(answer).contains(s)) {
                for(int i=0; i<length ;i++){
                    if(answer[i] == s.charAt(0)){
                        result[i] = s.charAt(0);
                        correct++;
                    }
                }
            }
            else{
                life--;
            }

            output = "";
            for(int i=0; i<length ;i++){
                output += result[i]+" ";
            }
        }

        if(length == correct){
            won = true;
        }

        if(life<=0){
            lost = true;
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
