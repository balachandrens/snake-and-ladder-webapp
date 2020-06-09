package com.mdoc.snakeandladder.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@JsonInclude
public class GameDTO {

    @NotNull
    @Min(1)
    @Max(6)
    private Integer diceValue;

    public Integer getDiceValue() {
        return diceValue;
    }

    public void setDiceValue(Integer diceValue) {
        this.diceValue = diceValue;
    }
}
