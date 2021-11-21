package net.broscorp;

import net.broscorp.primitives.Primitives;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PrimitiveTests {
  @Test
  void overFlowIntegerNegativeTest() {
    assertNotEquals(Primitives.minInteger(), Integer.MIN_VALUE);
    }

  @Test
  void overFlowIntegerPositiveTest() {
    assertNotEquals(Primitives.maxInteger(), Integer.MAX_VALUE);
  }

  @Test
  void convertLongToIntTest() {
    long longNumber = 2_147_483_647L;
    int intNumber = (int) longNumber;
    assertEquals(longNumber, intNumber);
  }

  @Test
  void convertMaxValueTest() {
    int longNumber = (int) Long.MAX_VALUE;
    assertEquals(-1, longNumber );
  }
  @Test
  void convertFloatToDouble() {
    float floatNumber = 5.381347f;
    double doubleNumber = floatNumber;
    assertEquals(floatNumber, doubleNumber);
  }

  @Test
  public void floatingPointMistake() {
    double x = 2.0;
    double y = 1.1;
    assertEquals(0.89999999999999991, x - y);
    assertNotEquals(0.1, x - y);
  }
}
