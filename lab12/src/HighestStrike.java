import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class HighestStrike implements ScoreResult {

    @Override
    public void result(BowlingGame bowlingGame) {
        ArrayList<BowlingPlayer> players = (ArrayList<BowlingPlayer>) bowlingGame.getPlayers();
        HashMap<BowlingPlayer, Integer> playerScore = new HashMap<>();
        for(BowlingPlayer player : players){
            int sumStrike = 0;
            for (int i=1; i<=3; i++){
                for(FrameScore frameScore : player.getFrameScore(i)){
                    if(frameScore.isStrike()) sumStrike++;
                }
            }
            playerScore.put(player, sumStrike);
        }
        players.sort(new Comparator<BowlingPlayer>() {
            @Override
            public int compare(BowlingPlayer o1, BowlingPlayer o2) {
                return (playerScore.get(o1)-playerScore.get(o2))*-1;
            }
        });
        for(BowlingPlayer player : players){
            System.out.println(player.getName()+" : Strike Total Score = "+playerScore.get(player));
        }
    }
}
