//elab-source:HangMan.java

import java.util.Scanner;

public class HangMan {
    private String target;
    private String guess;
    private int life;


    public HangMan(String target){
        this.target = target;
        this.life = 6;
        this.guess = "";
        for(int i=0; i<this.target.length(); i++){
            this.guess += "-";
        }
    }

    public void guess(String g){
            if(target.contains(g)){
                String check = target;
                String guessCheck = guess;
                check = check.replace(g, "+");
                guess = "";
                for(int i=0; i<target.length(); i++){
                    if('+' == (check.charAt(i))){
                        guess += g;

                    }
                    else if('-' == (guessCheck.charAt(i))){
                        guess += "-";
                    }
                    else {
                        guess += guessCheck.charAt(i);
                    }
                }
            }
            else {
                life--;
            }

            System.out.println(life+" "+guess);
            if(target.equals(guess)){
                System.out.println("Congratulations, you win");
            }
            if(life<=0){
                System.out.println("You lose, the answer is hangman");
            }
    }

    @Override
    public String toString() {
        return life+" "+guess;
    }

    public boolean isDead(){
        if(life>0){
            return false;
        }
        return true;
    }
}