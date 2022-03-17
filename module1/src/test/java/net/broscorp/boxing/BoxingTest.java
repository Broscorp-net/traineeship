package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
  public void unboxingBoxingException() {
    Integer actual = null;
    Assertions.assertThrows(NullPointerException.class, () -> {
      int expected = actual;
    });
  }
}
