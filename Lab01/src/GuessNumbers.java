public class GuessNumbers {
    private int target;

    public GuessNumbers(int target) {
        this.target = target;
    }

    public void guessTarget(int guess) {
        if (target == guess) {
            System.out.println("Correct");
        }
        else if (target > guess){
            System.out.println("too low");
        }
        else if (target < guess){
            System.out.println("too high");
        }
    }
}
