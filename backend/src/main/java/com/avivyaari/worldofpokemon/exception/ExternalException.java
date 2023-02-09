package com.avivyaari.worldofpokemon.exception;

import org.springframework.http.HttpStatus;

public class ExternalException extends Exception {

    private HttpStatus httpStatus;

    public ExternalException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
