package net.broscorp.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class TextExcepTest {

  @Test
  void exceptionTest() {
    String filename = "file.txt";
    try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
      System.out.println("Good!");
    } catch (IOException e) {
      System.out.println("Read Error file " + filename);
    } finally {
      System.out.println("Goodbye!");
    }
  }

  @Test
  void nextExceptionTest() {
    String str = null;
    try {
      if (str.equals(null)) {
        throw new NullPointerException();
      }
    } catch (NullPointerException e) {
      System.out.println("Catch NullPointerException");
    }
  }
}

