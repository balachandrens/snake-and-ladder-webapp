package com.mdoc.snakeandladder.service.core.board;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public interface GameBoard {

    PositionInfo getPositionInfo(Integer position);
    Integer getLastPosition();
}
