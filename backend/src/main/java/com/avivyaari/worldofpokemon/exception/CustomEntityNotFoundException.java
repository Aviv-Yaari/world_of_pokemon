package com.avivyaari.worldofpokemon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class CustomEntityNotFoundException extends CustomException {
    public CustomEntityNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
