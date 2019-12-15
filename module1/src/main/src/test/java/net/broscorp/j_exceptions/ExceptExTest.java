package net.broscorp.j_exceptions;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;


class ExceptExTest {

  @Test()
  void exeptio() throws IOException {
    Exception exception = assertThrows(IOException.class, () -> {
      try (FileReader f = new FileReader("dead.txt")) {
      } finally {
        System.out.println("It was fun, but I gtg, sya");
      }
    });
    String expectedMessage = "dead.txt (Не удается найти указанный файл)";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void exept() {
    Exception exception = assertThrows(Exception.class, () -> {
      try (FileReader f = new FileReader("dead.txt")) {
      } finally {
        System.out.println("It was fun, but I gtg, sya");
      }
    });
    String expectedMessage = "dead.txt (Не удается найти указанный файл)";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }
}