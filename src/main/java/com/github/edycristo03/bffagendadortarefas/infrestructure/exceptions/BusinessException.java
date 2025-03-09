package com.github.edycristo03.bffagendadortarefas.infrestructure.exceptions;



public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
