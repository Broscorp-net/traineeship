package net.broscorp.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

  @Test
  private String tryReadFileAndGetException() {
    File file = new File("D:/test.txt");
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      throw new IOException();
    } catch (FileNotFoundException ex) {
      return "Catch FileNotFoundException";
    } catch (IOException e) {
      return "Catch IOException";
    } finally {
      return "Finally here";
    }
  }

  @Test
  void catchIoexceptionAndGetFinally() {
    assertEquals("Finally here", tryReadFileAndGetException());
  }

  @Test
  void catchParentOfException() {
    try {
      throw new ArithmeticException();
    } catch (RuntimeException ex) {
      assertEquals(ArithmeticException.class, ex.getClass());
    }
  }
}
