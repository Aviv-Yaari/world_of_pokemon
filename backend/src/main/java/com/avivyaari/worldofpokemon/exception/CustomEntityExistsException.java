package com.avivyaari.worldofpokemon.exception;

import jakarta.persistence.EntityExistsException;

public class CustomEntityExistsException extends EntityExistsException {
    
    public CustomEntityExistsException(String message) {
        super(message);
    }
}
