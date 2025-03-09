package com.github.edycristo03.bffagendadortarefas.controller;


import com.github.edycristo03.bffagendadortarefas.infrestructure.exceptions.ConflictException;
import com.github.edycristo03.bffagendadortarefas.infrestructure.exceptions.IllegalArgumentException;
import com.github.edycristo03.bffagendadortarefas.infrestructure.exceptions.ResourceNotFoundException;
import com.github.edycristo03.bffagendadortarefas.infrestructure.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new  ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> handleConflictException(ConflictException ex) {
        return new  ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleUnauthorizedException(UnauthorizedException ex) {
        return new  ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new  ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
