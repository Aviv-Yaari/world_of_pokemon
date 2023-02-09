package com.avivyaari.worldofpokemon.util;

import com.avivyaari.worldofpokemon.dto.ErrorResponse;
import com.avivyaari.worldofpokemon.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    
    @ExceptionHandler
    public ErrorResponse handleCustomException(CustomException e) {
        return new ErrorResponse(e.getMessage(), e.getStatus());
    }

    @ExceptionHandler
    public ErrorResponse handleInternalException(Exception e) {
        return new ErrorResponse("An internal error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
