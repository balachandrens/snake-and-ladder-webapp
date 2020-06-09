package com.mdoc.snakeandladder.service.core.logic;

import com.mdoc.snakeandladder.service.core.board.GameBoard;
import com.mdoc.snakeandladder.service.core.board.PositionInfo;
import com.mdoc.snakeandladder.service.core.player.Player;
import com.mdoc.snakeandladder.service.core.player.PlayerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultGameLogic implements GameLogic{


    private final GameBoard board;

    @Autowired
    public DefaultGameLogic(GameBoard board){
        this.board = board;
    }

    @Override
    public void traverse(Player player, Integer diceValue){
        Integer newPosition = player.getCurrentPosition() + diceValue;
        updatePlayerState(player,newPosition);
    }

    private void updatePlayerState(Player player, Integer newPosition){
        PositionInfo positionInfo = board.getPositionInfo(newPosition);
        if (null == positionInfo) player.updateBalance(-10);
        else updatePlayerState(player,positionInfo);
        setPlayerStatus(player);
    }

    private void updatePlayerState(Player player, PositionInfo positionInfo){
        player.updateBalance(positionInfo.getPositionType().getNumVal());
        player.setCurrentPosition(positionInfo.getDestination());
    }

    private void setPlayerStatus(Player player){
        if(player.getCurrentPosition().equals(board.getLastPosition())) player.setPlayerStatus(PlayerStatus.WON);
        else if(player.getBalance() <= 0 ) player.setPlayerStatus(PlayerStatus.LOST);
    }
}

