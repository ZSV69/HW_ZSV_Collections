import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void firstPlayerWin() {
        Player Kolya = new Player(1, "Коля", 400);
        Player Olya = new Player(2, "Оля", 300);
        Game game = new Game();

        game.register(Kolya);
        game.register(Olya);

        int expected = 1;
        int actual = game.round("Коля", "Оля");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWin() {
        Player Kolya = new Player(1, "Коля", 100);
        Player Olya = new Player(2, "Оля", 300);
        Game game = new Game();

        game.register(Kolya);
        game.register(Olya);

        int expected = 2;
        int actual = game.round("Коля", "Оля");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notWinPlayer() {
        Player Kolya = new Player(1, "Коля", 300);
        Player Olya = new Player(2, "Оля", 300);
        Game game = new Game();

        game.register(Kolya);
        game.register(Olya);

        int expected = 0;
        int actual = game.round("Коля", "Оля");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notRegisterPlayer1() {
        Player Kolya = new Player(1, "Коля", 700);
        Player Olya = new Player(2, "Оля", 300);
        Game game = new Game();

        game.register(Kolya);
        game.register(Olya);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Дима", "Оля");
        });
    }

    @Test
    public void notRegisterPlayer2() {
        Player Kolya = new Player(1, "Коля", 700);
        Player Olya = new Player(2, "Оля", 300);
        Game game = new Game();

        game.register(Kolya);
        game.register(Olya);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Коля", "Федя");
        });
    }


}
