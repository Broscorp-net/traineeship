package net.broscorp.generics;

public class MyCoolListException extends RuntimeException {

  String message;

  public MyCoolListException(String message) {
    this.message = message;
  }
}
