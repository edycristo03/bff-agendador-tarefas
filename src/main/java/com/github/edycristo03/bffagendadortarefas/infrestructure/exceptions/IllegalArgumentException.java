package com.github.edycristo03.bffagendadortarefas.infrestructure.exceptions;

public class IllegalArgumentException extends RuntimeException {

    public IllegalArgumentException(String message) {
        super(message);
    }

    public IllegalArgumentException(String message, Throwable throwable) {
        super(message, throwable);

    }



}
