package com.mdoc.snakeandladder.service.core.player;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class DefaultPlayer implements Player{

    private Integer balance;
    private Integer currentPosition;
    private PlayerStatus playerStatus;

    public DefaultPlayer(){
        this.balance = 500;
        this.currentPosition = 1;
        this.playerStatus = PlayerStatus.PLAYING;
    }

    @Override
    public Integer getBalance() {
        return balance;
    }

    @Override
    public void updateBalance(Integer value){
        this.balance += value;
    }

    @Override
    public Integer getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public void setCurrentPosition(Integer currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    @Override
    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    @Override
    public void resetPlayer() {
        this.balance = 500;
        this.currentPosition = 1;
        this.playerStatus = PlayerStatus.PLAYING;
    }
}
