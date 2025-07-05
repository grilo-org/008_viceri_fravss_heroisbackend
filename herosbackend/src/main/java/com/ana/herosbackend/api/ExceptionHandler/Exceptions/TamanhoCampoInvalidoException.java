package com.ana.herosbackend.api.ExceptionHandler.Exceptions;

public class TamanhoCampoInvalidoException extends RuntimeException {
    public TamanhoCampoInvalidoException(String message) {
        super(message);
    }
}
