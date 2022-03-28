package net.broscorp.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

  @Test
  public void tryWithResource() {
    try (BufferedReader reader = new BufferedReader(new FileReader("brokePath"))) {
      reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Hello bro!");
    }
  }

  @Test
  public void catchAncestorException() {
    try {
      int number = 10;
      for (int i = 5; i >= 0; i--) {
        number /= i;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
