//elab-source:HangMan.java

public class HangMan {
    private String target;
    private String guess;
    private int life;
    private boolean gameRun;


    public HangMan(String target){
        this.target = target;
        this.life = 6;
        this.guess = "";
        for(int i=0; i<this.target.length(); i++){
            this.guess += "-";
        }
        System.out.println(life+" "+guess);
        gameRun = true;
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
                gameRun = false;
            }
            if(life<=0){
                System.out.println("You lose, the answer is "+target);
                gameRun = false;
            }
    }

    public boolean isGameRun() {
        return gameRun;
    }
}