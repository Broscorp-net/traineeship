package net.broscorp.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

  Exceptions exceptions = new Exceptions();

  @Test
  void tryReadFileAndGetMessageFromFinally() {
    String expect = "Finally here";
    String result = exceptions.readFile(new File("D:/test.txt"));
    assertEquals(expect, result);
  }

  // убеждаемся, что перехват RuntimeException корректно обрабатывает ArithmeticException
  @Test
  void catchParentOfArithmeticException() {
    assertThrows(RuntimeException.class, () -> {
      exceptions.throwArithmeticException();
    });
  }
}
