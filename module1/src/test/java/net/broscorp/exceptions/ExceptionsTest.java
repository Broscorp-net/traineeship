package net.broscorp.exceptions;

import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class ExceptionsTest {
  @Test
  public void checkFileException() {
    try {
      FileReader fr = new FileReader("somefile.txt");
    } catch (IOException exception) {
      exception = null;
    } finally {
      System.out.println("Bye");
    }
  }
}
