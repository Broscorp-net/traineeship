package net.broscorp.exceptions;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class TryWithResourcesTest {

  @Test
  public void showcaseTryWithResourcesTest() {
    //java.io.FileNotFoundException when trying to open file
    assertThrows(IOException.class, () -> {
      BufferedReader reader = new BufferedReader(new FileReader("fileName"));
    });
  }

  @Test
  public void showcaseFinallyTest() {
    try (BufferedReader reader = new BufferedReader(new FileReader("fileName"));) {
      System.out.println("Something went wrong");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("This block runs anyway");
    }
  }

  /**
   * Comment on the practice. Basically, catching Exception is not a great idea. In my humble
   * opinion this practice is reserved for custom exceptions. But this code at least shows that you
   * can catch the parent class when you catch the inherited class.
   */
  @Test
  public void testCatchParent() {
    try (BufferedReader reader = new BufferedReader(new FileReader("fileName"));) {
      System.out.println("Something went wrong");
    } catch (Exception e) {
      System.out.println("This is basic Exception");
    }
  }
}
