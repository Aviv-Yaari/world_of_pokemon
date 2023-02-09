package com.avivyaari.worldofpokemon.exception;

import jakarta.persistence.EntityNotFoundException;

public class CustomEntityNotFoundException extends EntityNotFoundException {
    public CustomEntityNotFoundException(String message) {
        super(message);
    }
}
