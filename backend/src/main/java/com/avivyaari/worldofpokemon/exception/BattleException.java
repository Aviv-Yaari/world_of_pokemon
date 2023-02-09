package com.avivyaari.worldofpokemon.exception;

import org.springframework.http.HttpStatus;

public class BattleException extends ExternalException {
    private HttpStatus httpStatus;
    
    public BattleException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
        this.httpStatus = httpStatus;
    }
}
