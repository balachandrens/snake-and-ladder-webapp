package com.mdoc.snakeandladder.service.core.board;

public enum PositionType {
    NORMAL(0),SNAKE(-100),LADDER(+100);
    private int numVal;
    PositionType(int numVal) { this.numVal = numVal; }
    public int getNumVal() { return numVal; }
}