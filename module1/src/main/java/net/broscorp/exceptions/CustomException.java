package net.broscorp.exceptions;

public class CustomException extends RuntimeException {

  private final String exceptionMessage = "This is a custom exception";

  public CustomException() {
    super();
  }

  @Override
  public String getMessage() {
    return exceptionMessage;
  }
}
