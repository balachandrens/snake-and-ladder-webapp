package com.mdoc.snakeandladder.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude
public class GameResultDTO {

    @NotNull
    private String gameResult;

    public GameResultDTO(String gameResult){
        this.gameResult = gameResult;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }
}
