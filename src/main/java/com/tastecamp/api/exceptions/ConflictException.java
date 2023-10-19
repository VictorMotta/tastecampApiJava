package com.tastecamp.api.exceptions;

public class ConflictException extends RuntimeException{
  public ConflictException(String message){
    super(message);
  }
}
