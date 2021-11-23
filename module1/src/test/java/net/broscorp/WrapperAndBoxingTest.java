package net.broscorp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class WrapperAndBoxingTest {

  @Test
  void wrapperComparison() {
    Integer one = 123;
    Integer two = 123;

    assertTrue(one == two);
  }

  @Test
  void wrapperFalseComparison() {
    Integer one = new Integer(123);
    Integer two = new Integer(123);

    assertFalse(one == two);
  }

  @Test
  void wrapperFalseComparisonTwo() {
    Boolean one = new Boolean(true);
    Boolean two = new Boolean(true);

    assertFalse(one == two);
  }

  @Test
  void unboxingException() {
    Integer number = null;
    assertThrows(NullPointerException.class, () -> new Integer(number), "null pointer exception");
  }
}
