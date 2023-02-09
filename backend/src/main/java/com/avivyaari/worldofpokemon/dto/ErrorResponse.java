package com.avivyaari.worldofpokemon.dto;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private String message;
    private String statusText;
    
    private int statusCode;

    public ErrorResponse(String message, HttpStatus status) {
        this.message = message;
        this.statusText = status.getReasonPhrase();
        this.statusCode = status.value();
    }

    public String getMessage() {
        return message;
    }

    public String getStatusText() {
        return statusText;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
