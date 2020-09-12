package net.broscorp.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionThrowlerTest {

  private final ExceptionThrower exceptionThrower = new ExceptionThrower();

  @Test
  public void shouldReturnMessageFromFinallyBlock() {
    String expectedResult = "Oops... Goodbye from finally block!";

    String actualResult = exceptionThrower.throwIoException();

    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  public void shouldReturnMessageFromFirstCatchBlock() {
    String expectedResult = "Hello from first catch block!";

    String actualResult = exceptionThrower.throwFileNotFoundException();

    Assertions.assertEquals(expectedResult, actualResult);
  }
}
