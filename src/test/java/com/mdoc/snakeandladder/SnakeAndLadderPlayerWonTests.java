package com.mdoc.snakeandladder;

import com.mdoc.snakeandladder.service.core.board.DefaultGameBoard;
import com.mdoc.snakeandladder.service.core.board.GameBoard;
import com.mdoc.snakeandladder.service.core.logic.DefaultGameLogic;
import com.mdoc.snakeandladder.service.core.logic.GameLogic;
import com.mdoc.snakeandladder.service.core.player.DefaultPlayer;
import com.mdoc.snakeandladder.service.core.player.Player;
import com.mdoc.snakeandladder.service.core.player.PlayerStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SnakeAndLadderPlayerWonTests {

    private static GameBoard board = new DefaultGameBoard();
    private static GameLogic gameLogic = new DefaultGameLogic(board);
    private static Player player = new DefaultPlayer();

    @Parameter(0)
    public Integer diceValue;
    @Parameter(1)
    public Integer newPosition;
    @Parameter(2)
    public Integer expectedBalance;
    @Parameter(3)
    public PlayerStatus playerStatus;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {3,4,500,PlayerStatus.PLAYING},
                {1,10,600,PlayerStatus.PLAYING},
                {4,2,500,PlayerStatus.PLAYING},
                {3,10,600,PlayerStatus.PLAYING},
                {2,26,700,PlayerStatus.PLAYING},
                {6,32,700,PlayerStatus.PLAYING},
                {6,38,700,PlayerStatus.PLAYING},
                {2,45,800,PlayerStatus.PLAYING},
                {6,45,790,PlayerStatus.PLAYING},
                {4,49,790,PlayerStatus.WON}
        };
        return Arrays.asList(data);
    }

    @Test
    public void testGame() {
        gameLogic.traverse(player,diceValue);
        assertEquals(newPosition,player.getCurrentPosition());
        assertEquals(expectedBalance,player.getBalance());
        assertEquals(playerStatus.name(),player.getPlayerStatus().name());
    }
}
