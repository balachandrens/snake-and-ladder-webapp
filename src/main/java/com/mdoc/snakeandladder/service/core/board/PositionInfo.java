package com.mdoc.snakeandladder.service.core.board;


public class PositionInfo {

    private final PositionType positionType;
    private final Integer destination;


    public PositionInfo(PositionType positionType, Integer destination){
        this.positionType = positionType;
        this.destination = destination;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public Integer getDestination() {
        return destination;
    }

}
