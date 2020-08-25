package net.broscorp.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {
  Path path;

  @BeforeEach
  void setUp() {
    path = Paths.get("/Users/mac/NotExistedFile.txt").toAbsolutePath();
  }

  @Test
  void catchIOExceptionTest() {
    String message = "I cannot find exception :(";
    try {
      BufferedReader bufferedReader = Files.newBufferedReader(path);
    } catch (IOException e) {
      message = "File not existed! Good bye, man :)";
    } finally {
      System.out.println(message);
    }
    assertTrue(Files.notExists(path));
    assertEquals("File not existed! Good bye, man :)", message);
  }

  @Test
  void catchAncestorException(){
    assertThrows(FileNotFoundException.class, () -> {
      try {
        FileReader fileReader = new FileReader(path.toFile());
      } catch (FileNotFoundException e) {
        throw new FileNotFoundException("Gotcha!");
      } catch (IOException e) {
        throw new IOException();
      }
    });
  }
}
