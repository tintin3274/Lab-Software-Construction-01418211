public class FrameScore {
    private int score;
    private boolean isStrike;

    public void addScore(int score){
        this.score = score;
        isStrike= score==10;
    }

    public void addScore(int score1, int score2){
        this.score = score1 + score2;
        isStrike = false;
    }

    public int getScore() {
        return score;
    }

    public boolean isStrike() {
        return isStrike;
    }
}
