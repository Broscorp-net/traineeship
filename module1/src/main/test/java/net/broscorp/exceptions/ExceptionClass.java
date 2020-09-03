package net.broscorp.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ExceptionClass {

  @Test
  public void checkFinallyExceptionMassage() {
    assertEquals("Finally massage!", finallyExceptionMassage());
  }

  @Test
  public void interceptingAncestorsExceptionChecker() {
    assertThrows(FileNotFoundException.class, () -> {
      try (FileReader fileReader = new FileReader("TextFile.txt")) {
        System.out.println(fileReader.toString());
      } catch (FileNotFoundException e) {
        throw new FileNotFoundException("File not exists!");
      } catch (IOException e) {
        throw new IOException(e.getMessage());
      }
    });
  }

  private String finallyExceptionMassage() {
    try (FileReader fileReader = new FileReader("TextFile.txt")) {
      return fileReader.toString();
    } catch (FileNotFoundException e) {
      throw new IOException(e.getMessage());
    } finally {
      return "Finally massage!";
    }
  }

}
