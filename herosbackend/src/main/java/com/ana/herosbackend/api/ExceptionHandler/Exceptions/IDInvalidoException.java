package com.ana.herosbackend.api.ExceptionHandler.Exceptions;

public class IDInvalidoException extends RuntimeException {
    public IDInvalidoException(String message) {
        super(message);
    }
    public IDInvalidoException() {
        super("O formato do id é inválido");
    }
}
