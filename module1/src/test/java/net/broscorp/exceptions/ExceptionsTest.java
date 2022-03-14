package net.broscorp.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class ExceptionsTest {
  @Test
  public void tryWithResourcesTest() {
    try (FileReader fileWriter = new FileReader("C:\\ProgramData")) {
      fileWriter.read();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("bye!");
    }
  }

  @Test
  public void parentExceptionsTest() {
    try {
      int temp = (Math.random() <= 0.5) ? 1 : 2;

      if (temp == 1) {
        throw new IOException();
      } else {
        throw new FileNotFoundException();
      }
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }
}
