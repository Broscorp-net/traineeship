package net.broscorp.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

  @Test
  public void shouldThrowIoExceptionWhenFileDoesNotExist() {
    assertThrows(IOException.class, this::tryWithResources);
  }

  private void tryWithResources() throws IOException {
    try (Stream<String> lines = Files.lines(Paths.get("FileDoesNotExist.txt"))) {
      // neverland
    } catch (IOException exception) {
      throw new IOException(exception);
    } finally {
      System.out.println("Have a nice day!");
    }
  }

  @Test
  public void exceptionInterception() {
    try {
      throw new CustomException();
    } catch (RuntimeException exception) {
      assertEquals(exception.getMessage(), "This is a custom exception");
    }
  }

}
