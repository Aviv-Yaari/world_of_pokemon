package com.avivyaari.worldofpokemon.util;

import com.avivyaari.worldofpokemon.dto.ErrorResponse;
import com.avivyaari.worldofpokemon.exception.ExternalException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    
    @ExceptionHandler
    public ErrorResponse handleExternalException(ExternalException e) {
        return new ErrorResponse(e.getMessage(), e.getHttpStatus());
    }

    @ExceptionHandler
    public ErrorResponse handleInternalException(Exception e) {
        return new ErrorResponse("An internal error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
