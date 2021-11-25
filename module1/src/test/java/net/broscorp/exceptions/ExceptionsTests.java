package net.broscorp.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
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
    assertThrows(NoSuchFileException.class,
        () -> Files.newBufferedReader(Paths.get(filename)));
  }

  @Test
  void testAncestorException() {
    String str = null;
    try {
      if (str.equals(null)) {
        throw new NullPointerException();
      }
    } catch (NullPointerException e) {
      System.out.println("Catch exception");
    }
    assertThrows(NullPointerException.class,
        () -> str.equals(null));
  }
}
