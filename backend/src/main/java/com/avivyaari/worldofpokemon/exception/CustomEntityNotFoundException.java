package com.avivyaari.worldofpokemon.exception;

import org.springframework.http.HttpStatus;

public class CustomEntityNotFoundException extends ExternalException {
    public CustomEntityNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
