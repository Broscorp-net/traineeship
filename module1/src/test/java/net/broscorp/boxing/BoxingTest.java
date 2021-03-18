package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  public void resTrue() {
    Double first = -10.2;
    Double second = -10.2;
    Assertions.assertTrue(first.doubleValue() == second.doubleValue());
  }

  @Test
  public void resFalse() {
    Double first = -10.2;
    Double second = -10.2;
    Assertions.assertFalse(first == second);
  }

  @Test
  public void resThrows() {
    Double first = null;
    Assertions.assertThrows(NullPointerException.class, () -> {
      double second = first;
    }, "error");
  }

}
