package com.ana.herosbackend.api.ExceptionHandler.Exceptions;

public class HeroiNaoEncontradoException extends RuntimeException {


  public HeroiNaoEncontradoException(String message) {
    super(message);
  }
  public HeroiNaoEncontradoException() {
    super("Herói não encontrado.");
  }
}