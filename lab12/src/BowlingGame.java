import java.util.ArrayList;
import java.util.Collection;

public class BowlingGame {
    private Collection<BowlingPlayer> players;

    public BowlingGame() {
        players = new ArrayList<>();
    }

    public void addPlayer(BowlingPlayer player){
        players.add(player);
    }

    public Collection<BowlingPlayer> getPlayers() {
        return players;
    }
}
