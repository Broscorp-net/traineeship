package net.broscorp.exceptions;

import java.io.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExceptionsTest {

  @Test
  void testFileOpenWithException() {
    try (BufferedReader br =
        new BufferedReader(new FileReader("non_existing_path"))) {
    } catch (IOException e) {
      System.out.println("Caught IOException");
    } finally {
      System.out.println("Bye");
    }
  }
}