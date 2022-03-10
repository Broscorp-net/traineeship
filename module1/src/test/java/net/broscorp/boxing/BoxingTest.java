package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class BoxingTest {
  @Test
  public void compareWrappersTrue() {
    Integer actual = 127;
    Integer expected = 127;
    Assertions.assertSame(expected, actual);
  }

  @Test
  public void compareWrappersFalse() {
    Integer actual = 128;
    Integer expected = 128;
    Assertions.assertNotSame(expected, actual);
  }

  @Test
  public void compareStringTrue() {
    String actual = "Hello world!";
    String expected = "Hello world!";
    Assertions.assertSame(expected, actual);
  }

  @Test
  public void compareStringFalse() {
    String actual = "Hello world!";
    String expected = new String("Hello world!");
    Assertions.assertNotSame(expected, actual);
  }

  @Test
  public void unboxingBoxingException() {
    Integer actual = null;
    Assertions.assertThrows(NullPointerException.class, new Executable() {
      @Override
      public void execute() {
        int expected = actual;
      }
    });
  }
}
