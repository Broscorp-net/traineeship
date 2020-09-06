package net.broscorp.exceptions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

  @Test
  void tryWithResourcesThrowsException() {
    String exMsg = "";
    String finalWords = "";

    try (BufferedReader reader = Files.newBufferedReader(Paths.get("some_file.txt"))) {
      String line = reader.readLine();
    } catch (IOException e) {
      exMsg = e.getMessage();
      System.out.println(exMsg);
    } finally {
      finalWords = "Bye...";
      System.out.println(finalWords);
    }

    assertFalse(exMsg.isEmpty());
    assertFalse(finalWords.isEmpty());
  }

  @Test
  void catchParentException() {
    // IOException is a parent of FileNotFoundException
    assertThrows(IOException.class, () -> {
      try (FileReader reader = new FileReader("some_file.txt")) {
        int i = reader.read();
      }
    });
  }

}
