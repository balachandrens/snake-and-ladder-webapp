package com.mdoc.snakeandladder.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Value;

@JsonInclude
public class ErrorResponse {

    @Value("Error occurred")
    private final String error_message;

    public ErrorResponse(String message){
        this.error_message = message;
    }

    public String getError_message() {
        return error_message;
    }
}
