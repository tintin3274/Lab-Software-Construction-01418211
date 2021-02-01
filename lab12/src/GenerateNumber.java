import java.util.Random;

public class GenerateNumber {
    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        int score1, score2;
        for(int i=0; i<30; i++){
            score1 = generateRandomIntIntRange(0, 10);
            if (score1 == 10) {
                System.out.println(score1);
            }
            else {
                score2 = generateRandomIntIntRange(0, 10-score1);
                System.out.println(score1+","+score2);
            }
        }
    }
}
