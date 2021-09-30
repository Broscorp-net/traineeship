package net.broscorp.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

public class ExceptionsTests {

  @Test
  void testException() {
    String filename = "cities.txt";

    try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
      System.out.println("All is ok!");
    } catch (IOException e) {
      System.out.println("Can't read file with name = " + filename);
    } finally {
      System.out.println("Goodbye!");
    }
  }

  @Test
  void testAncestorException() {
    String s;
    try {
      s = null;
      if (s.equals(null)) {
        throw new NullPointerException("String is null, throw NPE");
      }
    } catch (Throwable e) {
      System.out.println("Catch exception");
    }
  }
}
