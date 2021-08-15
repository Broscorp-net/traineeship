package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.DecimalFormat;
import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  void overflow() {
    System.out.println("[" + Byte.MIN_VALUE + " , " +  Byte.MAX_VALUE + "]");
    System.out.println("Byte.SIZE  =   " + Byte.SIZE);

    byte value = Byte.MAX_VALUE;
    byte newValue = (byte) (value + 20);
    System.out.println(newValue);

    assertFalse(newValue > value);
  }

  @Test
  void testLongToInt() {
    long longBigNumber = Long.MAX_VALUE;
    int intSmallNumber = 1000;

    intSmallNumber = (int) longBigNumber;
    System.out.println(intSmallNumber);

    assertFalse(longBigNumber == intSmallNumber);
  }

  @Test
  void testDoubleToFloat() {
    double doubleNumber = Double.MAX_VALUE;
    float floatNumber = (float) doubleNumber;

    System.out.println(floatNumber);

    assertFalse(doubleNumber == floatNumber);
  }

  @Test
  void testPromlemsWithDouble() {
    Double value = 1.0;
    Double value2 = 0.6;

    for (int i = 0; i < 4; i++) {
      value -= 0.1;
    }

    System.out.println(value);
    assertFalse(value == value2);
    assertTrue(Math.ceil(value) == Math.ceil(value2));
  }
}

