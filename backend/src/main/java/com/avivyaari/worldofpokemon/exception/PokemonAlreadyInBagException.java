package com.avivyaari.worldofpokemon.exception;

import org.springframework.http.HttpStatus;

public class PokemonAlreadyInBagException extends CustomException {
    public PokemonAlreadyInBagException() {
        super("Pokemon already exists in bag", HttpStatus.BAD_REQUEST);
    }
    
    public PokemonAlreadyInBagException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
