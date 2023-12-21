package org.max.home;

import org.junit.jupiter.api.*;
import org.max.home.Door;
import org.max.home.Game;
import org.max.home.Player;

import java.util.ArrayList;
import java.util.List;

public class MyGameTest {
    List<Door> doors;
    Player player;
    Game game;

    @BeforeEach
    void initDoors() {
        doors = new ArrayList<>();
        doors.add(new Door(false));
        doors.add(new Door(false));
        doors.add(new Door(true));
    }

    @Test
    void testRoundWithoutChangingSelectionGetLose() {
        //given
        player = new Player("Player1", false);
        game = new Game(player, doors);
        //when
        boolean result = game.round(1).isPrize();
        //then
        Assertions.assertEquals(3, doors.size());
        Assertions.assertFalse(result);

    }

    @Test
    void testRoundWithoutChangingSelectionGetWin() {
        //given
        player = new Player("Player1", false);
        game = new Game(player, doors);
        //when
        boolean result = game.round(2).isPrize();
        //then
        Assertions.assertEquals(3, doors.size());
        Assertions.assertTrue(result);
    }

    @Test
    void testRoundWithChangingSelectionGetLose() {
        //given
        player = new Player("Player1", true);
        game = new Game(player, doors);
        //when
        boolean result = game.round(2).isPrize();
        //then
        Assertions.assertEquals(2, doors.size());
        Assertions.assertFalse(result);
    }

    @Test
    void testRoundWithChangingSelectionGetWin() {
        //given
        player = new Player("Player1", true);
        game = new Game(player, doors);
        //when
        boolean result = game.round(1).isPrize();
        //then
        Assertions.assertEquals(2, doors.size());
        Assertions.assertTrue(result);
    }

    @Test
    void testRoundWithChangingSelectionGetWinDoor2() {
        //given
        player = new Player("Player1", true);
        game = new Game(player, doors);
        //when
        boolean result = game.round(2).isPrize();
        //then
        Assertions.assertEquals(2, doors.size());
        Assertions.assertTrue(result);
    }

}
