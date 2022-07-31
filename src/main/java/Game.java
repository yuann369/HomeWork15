import java.util.ArrayList;
import java.util.Collection;

public class Game {
    protected Collection<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (!players.contains(findByName(playerName1))) {
            throw new NotRegisteredException("Player: " + playerName1 + " not found");
        }
        if (!players.contains(findByName(playerName2))) {
            throw new NotRegisteredException("Player: " + playerName2 + " not found");
        }

        int strength1 = findByName(playerName1).getStrength();
        int strength2 = findByName(playerName2).getStrength();

        if (strength1 > strength2) {
            return 1;
        } else if (strength1 < strength2) {
            return 2;
        } else return 0;

    }
}
