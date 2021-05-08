package net.broscorp.exceptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

  @Test
  public void tryWithResourcesTest() {
    File someNonexistentFileName = new File("noSuchFile.txt");
    try (BufferedReader bufferedReader = new BufferedReader(
        new FileReader(someNonexistentFileName))) {
      while (bufferedReader.ready()) {
        System.out.println(bufferedReader.readLine());
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Bye-Bye!");
    }
  }

  @Test
  public void parentExceptionCatch() {
    try {
      int[] array = {1, 2, 3};
      array[3] = 4;
    } catch (Exception e) {
      System.out.println(e);
      assertTrue(e instanceof IndexOutOfBoundsException);
    }
  }
}
