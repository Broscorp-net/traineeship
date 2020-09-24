package net.broscorp.exceptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

  @Test
  public void tryWithResoursesTest() {
    File file = new File("noFile.txt");
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
    } catch (IOException e) {
      System.out.println("IOException catch.");
    } finally {
      System.out.println("Good bye! :(");
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
