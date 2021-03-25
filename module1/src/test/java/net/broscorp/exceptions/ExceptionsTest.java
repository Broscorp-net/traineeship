package net.broscorp.exceptions;

import java.io.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

  @Test
  public void checkOnNullPointerException() {
    try {
      Object obj = null;
      obj.hashCode();
    } catch (RuntimeException ex) {
      Assertions.assertTrue(ex instanceof NullPointerException);
    }
  }

  @Test
  public void checkOnIOException() {
    try (BufferedReader reader = new BufferedReader(new FileReader("inputFile"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line + "\n");
      }
    } catch (IOException e) {
      System.err.println(e);
      Assertions.assertTrue(e instanceof IOException);
    } finally {
      System.out.println("Goodbye))");
    }
  }

}
