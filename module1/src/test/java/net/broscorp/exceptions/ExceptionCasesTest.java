package net.broscorp.exceptions;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedInputStream;

import java.io.FileInputStream;

import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ExceptionCasesTest {

  private String inputFile;


  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  /*
   * If file (inputFile) not found will throw FileNotFoundException, else
   * throw IOException
   */
  @Test
  @DisplayName("Should throw IOException")
  public void shouldThrowIoException() {
    inputFile = "test.txt";
    String expectedMessageException = "Throw IOException manually";
    String actualMessageException = null;

    try (FileInputStream fileInputStream = new FileInputStream(inputFile);
          BufferedInputStream bufferedInput = new BufferedInputStream(fileInputStream)) {

      throw new IOException("Throw IOException manually");


    } catch (IOException ex) {
      actualMessageException = ex.getMessage();
      System.err.println(ex.getMessage());

    } finally {
      System.out.println("Goodbye!");

    }
    assertNotNull(actualMessageException);
  }


  @Test
  @DisplayName("Should throw ancestors of exceptions")
  public void shouldThrowAncestorsOfExceptions() {

    assertThrows(IllegalArgumentException.class, () -> {

      try {

        throw new NumberFormatException("Only positive numbers.");

      } catch (NumberFormatException ex) {

        throw new IllegalArgumentException("Value out of range.", ex);

      } catch (IllegalArgumentException ex) {

        System.err.println(ex.getMessage());

      }
    });
  }

}
