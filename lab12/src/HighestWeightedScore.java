import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class HighestWeightedScore implements ScoreResult {
    private double[] weight;

    public HighestWeightedScore(double weight1, double weight2, double weight3) {
        weight = new double[3];
        weight[0] = weight1;
        weight[1] = weight2;
        weight[2] = weight3;
    }

    @Override
    public void result(BowlingGame bowlingGame) {
        ArrayList<BowlingPlayer> players = (ArrayList<BowlingPlayer>) bowlingGame.getPlayers();
        HashMap<BowlingPlayer, Double> playerScore = new HashMap<>();
        for(BowlingPlayer player : players){
            double sumWeightedScore = 0;
            for (int i=1; i<=3; i++){
                double sumRoundScore = 0;
                for(FrameScore frameScore : player.getFrameScore(i)){
                    sumRoundScore += frameScore.getScore();
                }
                sumWeightedScore += (sumRoundScore/100)*weight[i-1];
            }
            playerScore.put(player, sumWeightedScore);
        }
        players.sort(new Comparator<BowlingPlayer>() {
            @Override
            public int compare(BowlingPlayer o1, BowlingPlayer o2) {
                return Double.compare(playerScore.get(o1), playerScore.get(o2))*-1;
            }
        });
        for(BowlingPlayer player : players){
            System.out.format(player.getName()+" : Weighted Total Score = %.2f\n", playerScore.get(player));
        }
    }
}
