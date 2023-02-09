package com.avivyaari.worldofpokemon.exception;

import org.springframework.http.HttpStatus;

public class CustomEntityExistsException extends CustomException {
    
    public CustomEntityExistsException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
