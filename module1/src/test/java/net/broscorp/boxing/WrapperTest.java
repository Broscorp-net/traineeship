package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class WrapperTest {

  @Test
  public void testIntegerNotEquals() {
    Integer value1 = new Integer(1);
    Integer value2 = new Integer(1);

    assertFalse(value1 == value2);
  }

  @Test
  public void testPrimitivesEquals() {
    int value1 = 2;
    int value2 = 2;

    assertTrue(value1 == value2);
  }
}
