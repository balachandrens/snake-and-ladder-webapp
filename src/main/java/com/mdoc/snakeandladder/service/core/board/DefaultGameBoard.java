package com.mdoc.snakeandladder.service.core.board;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Scope("singleton")
public class DefaultGameBoard implements GameBoard{

    private static final int finalPosition = 49;

    private final Map<Integer, PositionInfo> boardPositionInfoMap;

    public DefaultGameBoard(){
        boardPositionInfoMap = new HashMap<Integer, PositionInfo>();
        populateBoardElements();
    }

    @Override
    public PositionInfo getPositionInfo(Integer position){
        return boardPositionInfoMap.get(position);
    }

    @Override
    public Integer getLastPosition() {
        return finalPosition;
    }

    private void populateBoardElements(){
        populateDefaultPositionInfo();
        populateLadderInfo();
        populateSnakeInfo();
    }

    private void populateDefaultPositionInfo(){
        for(int index=1;index<50;index++){
            boardPositionInfoMap.put(index, new PositionInfo(PositionType.NORMAL,index));
        }
    }

    private void populateLadderInfo(){
        addPositionInfo(5, PositionType.LADDER, 10);
        addPositionInfo(12, PositionType.LADDER, 26);
        addPositionInfo(16, PositionType.LADDER, 29);
        addPositionInfo(19, PositionType.LADDER, 33);
        addPositionInfo(35, PositionType.LADDER, 36);
        addPositionInfo(40, PositionType.LADDER, 45);
    }

    private void populateSnakeInfo(){
        addPositionInfo(14, PositionType.SNAKE, 2);
        addPositionInfo(23, PositionType.SNAKE, 8);
        addPositionInfo(43, PositionType.SNAKE, 41);
        addPositionInfo(47, PositionType.SNAKE, 37);
    }

    private void addPositionInfo(int position, PositionType positionType, int destination) {
        boardPositionInfoMap.put(position, new PositionInfo(positionType, destination));
    }

}
