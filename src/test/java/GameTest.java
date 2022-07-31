import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GameTest {
    private Game game = new Game();
    Player player1 = new Player(1, "Natalya", 10);
    Player player2 = new Player(2, "Anna", 6);
    Player player3 = new Player(3, "Petr", 20);
    Player player4 = new Player(4, "Ivan", 18);
    Player player5 = new Player(5, "Stepan", 20);

    @Test
    public void roundNotRegisteredFirstTest() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () ->
        {
            game.round("Vasya", "Ivan");

        });
    }

    @Test
    public void roundNotRegisteredSecondTest() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () ->
        {
            game.round("Petr", "Alex");

        });
    }

    @Test
    public void roundWinFirstTest() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int actual = game.round("Natalya", "Anna");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void roundWinSecondTest() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int actual = game.round("Ivan", "Petr");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void roundDrawTest() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int actual = game.round("Stepan", "Petr");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }
}
