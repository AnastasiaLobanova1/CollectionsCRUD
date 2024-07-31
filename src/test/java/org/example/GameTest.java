package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();


    @Test
    public void testWinFirstPlayer() {
        Player player1 = new Player(1, "Антон", 80);
        Player player2 = new Player(2, "Гена", 50);
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Антон", "Гена");
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testWinSecondPlayer() {
        Player player1 = new Player(1, "Антон", 50);
        Player player2 = new Player(2, "Гена", 80);
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Антон", "Гена");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void testNobodyWin() {
        Player player1 = new Player(1, "Антон", 80);
        Player player2 = new Player(2, "Гена", 80);
        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Антон", "Гена");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void testNotFoundExceptionFirstPlayer() {
        Player player1 = new Player(1, "Антон", 50);
        Player player2 = new Player(2, "Гена", 80);
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Вова", "Гена");
        });
    }
    @Test
    public void testNotFoundExceptionSecondPlayer() {
        Player player1 = new Player(1, "Антон", 50);
        Player player2 = new Player(2, "Гена", 80);
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Антон", "Вова");
        });
    }
    @Test
    public void testShouldSetIdPlayer () {
        Player player1 = new Player(1, "Антон", 50);
        Player player2 = new Player(2, "Гена", 80);
        game.register(player1);
        game.register(player2);
        player1.setId(3);
        player2.setId(4);

        Assertions.assertEquals(3, player1.getId());
        Assertions.assertEquals(4, player2.getId());
    }
    @Test
    public void testShouldSetNamePlayer () {
        Player player1 = new Player(1, "Антон", 50);
        Player player2 = new Player(2, "Гена", 80);
        game.register(player1);
        game.register(player2);
        player1.setName("Гоша");
        player2.setName("Кеша");

        Assertions.assertEquals("Гоша", player1.getName());
        Assertions.assertEquals("Кеша", player2.getName());
    }
    @Test
    public void testShouldSetStrengthPlayer () {
        Player player1 = new Player(1, "Антон", 50);
        Player player2 = new Player(2, "Гена", 80);
        game.register(player1);
        game.register(player2);
        player1.setStrength(10);
        player2.setStrength(40);

        Assertions.assertEquals(10, player1.getStrength());
        Assertions.assertEquals(40, player2.getStrength());
    }
}
