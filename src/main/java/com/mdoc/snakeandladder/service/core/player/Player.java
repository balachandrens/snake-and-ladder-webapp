package com.mdoc.snakeandladder.service.core.player;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public interface Player {
    Integer getBalance();
    void updateBalance(Integer value);
    Integer getCurrentPosition();
    void setCurrentPosition(Integer currentPosition);
    PlayerStatus getPlayerStatus();
    void setPlayerStatus(PlayerStatus playerStatus);
    void resetPlayer();
}
