package com.mdoc.snakeandladder.service;


import com.mdoc.snakeandladder.service.core.logic.GameLogic;
import com.mdoc.snakeandladder.service.core.player.Player;
import com.mdoc.snakeandladder.service.core.player.PlayerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameLogic gameLogic;
    private Player player;
    private OutputFormatter outputFormatter;

    @Autowired
    public GameService(GameLogic gameLogic){
        this.gameLogic = gameLogic;
    }

    @Autowired
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Autowired
    public void setOutputFormatter(OutputFormatter outputFormatter) {
        this.outputFormatter = outputFormatter;
    }

    public String startGame(){
        return outputFormatter.getPlayerStatusString(player);
    }

    public String play(Integer diceValue){
        gameLogic.traverse(player,diceValue);
        return getPlayerStatusString();
    }

    private String getPlayerStatusString(){
        String playerStatusString = outputFormatter.getPlayerStatusString(player);
        if (player.getPlayerStatus().equals(PlayerStatus.PLAYING)) return playerStatusString;
        player.resetPlayer();
        return playerStatusString + outputFormatter.resetStatusString();
    }
}
