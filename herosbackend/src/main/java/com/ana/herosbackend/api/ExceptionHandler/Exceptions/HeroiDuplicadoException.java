package com.ana.herosbackend.api.ExceptionHandler.Exceptions;

public class HeroiDuplicadoException extends RuntimeException {
    public HeroiDuplicadoException(String mensagem) {
        super(mensagem);
    }
}
