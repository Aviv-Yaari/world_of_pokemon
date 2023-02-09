package com.avivyaari.worldofpokemon.util;

import com.avivyaari.worldofpokemon.dto.ErrorResponse;
import com.avivyaari.worldofpokemon.exception.CustomEntityExistsException;
import com.avivyaari.worldofpokemon.exception.CustomEntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    
    @ExceptionHandler
    public ErrorResponse handleEntityNotFound(CustomEntityNotFoundException e) {
        return new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler
    public ErrorResponse handleEntityExists(CustomEntityExistsException e) {
        return new ErrorResponse(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ErrorResponse handleInternalException(Exception e) {
        return new ErrorResponse("An internal error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
