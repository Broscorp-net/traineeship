package net.broscorp.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class ExceptionTest {

  @Test
  void testShouldCatchIoExceptionAndPrintBye() {
    try (BufferedReader reader = new BufferedReader(new FileReader(""))) {
      reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Bye");
    }
  }

  @Test
  void testShouldCatchSuperForAll() {
    try (BufferedReader reader = new BufferedReader(new FileReader(""))) {
      reader.readLine();
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }
}
