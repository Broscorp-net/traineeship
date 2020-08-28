package net.broscorp.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;


public class ExampleOfException {

  @Test
  public void catchExceptionAndDoFinally() {
    assertEquals("Oops, sometime happen...", readFileWithException());
  }

  @Test
  public void catchAncestorsOfExceptions() {
    assertThrows(FileNotFoundException.class, () -> {
      try (FileReader reader = new FileReader("someText.txt")) {
        System.out.println(reader.toString());
      } catch (FileNotFoundException ex) {
        throw new FileNotFoundException("Not found");
      } catch (IOException ex) {
        throw new IOException(ex.getMessage());
      }
    });
  }

  private String readFileWithException() {
    try (FileReader reader = new FileReader("someTxt.txt")) {
      return reader.toString();
    } catch (IOException ex) {
      throw new IOException(ex.getMessage());
    } finally {
      return "Oops, sometime happen...";
    }
  }
}
