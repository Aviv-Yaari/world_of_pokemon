package com.avivyaari.worldofpokemon.exception;

import org.springframework.http.HttpStatus;

public class CustomEntityExistsException extends ExternalException {
    
    public CustomEntityExistsException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
