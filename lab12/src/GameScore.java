import java.util.ArrayList;

public class GameScore {
    private ArrayList<FrameScore> frames;

    public GameScore(){
        frames = new ArrayList<>();
    }

    public void addScore(FrameScore frame){
        frames.add(frame);
    }

    public void addScore(int score){
        FrameScore frame = new FrameScore();
        frame.addScore(score);
        frames.add(frame);
    }

    public void addScore(int score1, int score2){
        FrameScore frame = new FrameScore();
        frame.addScore(score1 , score2);
        frames.add(frame);
    }

    public ArrayList<FrameScore> getFrames() {
        return frames;
    }
}
