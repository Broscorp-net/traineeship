package net.broscorp.j_exceptions;

import static net.broscorp.j_exceptions.ExampleException.readFile;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ExampleExceptionTest {

  @Test
  void testFinally() {
    assertEquals("Good Bye", readFile("text.txt"));
  }

  @Test
  void testStringIndexOutOfBoundsException() {
    assertDoesNotThrow(ExampleException::catchStringIndexOutOfBoundsException);
  }

  @Test
  void testIndexOutOfBoundsException() {
    assertDoesNotThrow(ExampleException::catchIndexOutOfBoundsException);
  }

  @Test
  void testRuntimeException() {
    assertDoesNotThrow(ExampleException::catchRuntimeException);
  }

  @Test
  void testException() {
    assertDoesNotThrow(ExampleException::catchException);
  }

  @Test
  void testThrowable() {
    assertDoesNotThrow(ExampleException::catchThrowable);
  }
}
