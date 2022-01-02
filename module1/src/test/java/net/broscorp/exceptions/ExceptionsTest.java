package net.broscorp.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testing class
 */
class ExceptionsTest {

  @Test
  void testFileOpenWithException() {
    try (BufferedReader br =
        new BufferedReader(new FileReader("non_existing_path"))) {
      // do nothing
    } catch (IOException e) {
      // do nothing
    } finally {
      System.out.println("Bye");
    }
  }

  @Test
  void testCatchExceptionPredecessor() {
    try (BufferedReader br =
        new BufferedReader(new FileReader("non_existing_path"))) {
      // do nothing
    } catch (Throwable t) {
      // do nothing
    } finally {
      System.out.println("Bye");
    }
  }
}