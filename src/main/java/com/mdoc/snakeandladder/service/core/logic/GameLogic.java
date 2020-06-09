package com.mdoc.snakeandladder.service.core.logic;


import com.mdoc.snakeandladder.service.core.player.Player;
import org.springframework.stereotype.Service;

@Service
public interface GameLogic {

    void traverse(Player player, Integer diceValue) throws IllegalArgumentException;

}
