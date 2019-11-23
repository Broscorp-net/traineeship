package net.broscorp.j_exceptions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ExceptionsTest {

  @Test

  void testExceptionHierarchy() {
    Exceptions exceptions = new Exceptions();
    String file_Tap = "MyFile.txt";
    assertDoesNotThrow(() -> {
      exceptions.exceptionsHierarchy(file_Tap);
    });
  }
}

