//elab-source:MasterMind.java

public class MasterMind {
    private String target;

    public MasterMind(String target){
        this.target = target;
    }

    public String guess(String guess){
        int correctNumber = 0;
        int correctPosition = 0;

        if(target.contains(String.valueOf(guess.charAt(0)))){correctNumber++;}
        if(target.contains(String.valueOf(guess.charAt(1)))){correctNumber++;}
        if(target.contains(String.valueOf(guess.charAt(2)))){correctNumber++;}
        if(target.contains(String.valueOf(guess.charAt(3)))){correctNumber++;}

        if(target.charAt(0)==guess.charAt(0)){correctPosition++;}
        if(target.charAt(1)==guess.charAt(1)){correctPosition++;}
        if(target.charAt(2)==guess.charAt(2)){correctPosition++;}
        if(target.charAt(3)==guess.charAt(3)){correctPosition++;}

        if(correctNumber == 4 && correctPosition == 4){
            return "Congratulations, you just mastered my mind!!";
        }
        else {
            return correctNumber+" "+correctPosition;
        }
    }
}
