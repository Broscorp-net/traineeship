package net.broscorp.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class ExceptionTest {

  @Test
  void test() {
    try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.out.println("File not found");
    } finally {
      System.out.println("Good bye.");
    }
  }
}
