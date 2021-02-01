import java.util.ArrayList;
import java.util.Arrays;

public class BowlingPlayer {
    private String name;
    private GameScore[] gameScores;

    public BowlingPlayer(String name) {
        this.name = name;
        gameScores = new GameScore[3];
        gameScores[0] = new GameScore();
        gameScores[1] = new GameScore();
        gameScores[2] = new GameScore();
    }

    public String getName() {
        return name;
    }

    public void addScore(int game, int score){
        gameScores[game-1].addScore(score);
    }

    public void addScore(int game, int score1, int score2){
        gameScores[game-1].addScore(score1, score2);
    }

    public ArrayList<FrameScore> getFrameScore(int game){
        return gameScores[game-1].getFrames();
    }
}
