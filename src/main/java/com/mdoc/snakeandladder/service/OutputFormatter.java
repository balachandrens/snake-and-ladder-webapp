package com.mdoc.snakeandladder.service;


import com.mdoc.snakeandladder.service.core.player.Player;
import com.mdoc.snakeandladder.service.core.player.PlayerStatus;
import org.springframework.stereotype.Service;

@Service
public class OutputFormatter {

    private Player player;

    public String getPlayerStatusString(Player player){
        this.player = player;
        return getPlayerStatusString()
                + ": "
                + getNextChoiceString();
    }

    public String resetStatusString(){
        return "Resetting your position to "
                + player.getCurrentPosition()
                + " with Euro "
                + player.getBalance();
    }

    private String getPlayerStatusString(){
        return "Your are at position "+
                player.getCurrentPosition()
                + " with Euro "
                + player.getBalance();
    }

    private String getNextChoiceString(){
        if(player.getPlayerStatus().equals(PlayerStatus.PLAYING))
            return "Please post the die roll...";
        else if(player.getPlayerStatus().equals(PlayerStatus.WON))
            return "So you won the game. ";
        else
            return "So you Loose the game. ";
    }
}
