package net.broscorp.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

  @Test
  public void tryWithResourcesTest() {
    try (BufferedReader reader = new BufferedReader(new FileReader("somePath"))) {
      reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Goodbye!");
    }
  }

  @Test
  public void catchAncestorOfExceptionTest() {
    try {
      int a = 1 / 0;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
