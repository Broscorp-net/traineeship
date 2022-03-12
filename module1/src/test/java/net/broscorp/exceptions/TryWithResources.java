package net.broscorp.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

public class TryWithResources {
  //non existent file
  private static final String FILEPATH = "src/test/java/net/broscorp/exceptions/cities.txt";

  @Test
  void fileReader() {
    try (BufferedReader newReader = Files.newBufferedReader(Paths.get(FILEPATH))) {
      String line;
      while ((line = newReader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.out.println("Can't read file with path = " + FILEPATH);
    } finally {
      System.out.println("bye-bye");
    }
  }
}
