//elab-source:NumberGuessor.java

public class NumberGuessor {
    private int target;

    public NumberGuessor(int target){
        this.target = target;
    }
    public String guess(int guess){
        if(guess>target){return "too high";}
        else if(guess<target){return "too low";}
        else {return "correct";}
    }
}
