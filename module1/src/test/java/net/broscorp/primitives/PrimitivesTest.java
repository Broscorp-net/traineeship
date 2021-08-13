package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  void overflow() {
    System.out.println("[" + Byte.MIN_VALUE +" , " +  Byte.MAX_VALUE + "]");
    System.out.println("Byte.SIZE  =   " + Byte.SIZE);

    byte value = Byte.MAX_VALUE;
    byte newValue = (byte) (value + 20);
    System.out.println(newValue);

    assertFalse(newValue > value);
  }

  @Test
  void testLongToInt() {
    long longBigNumber = 214748364710L;
    int intSmallNumber = 1000;

    intSmallNumber = (int) longBigNumber;
    System.out.println(intSmallNumber);

    assertFalse(longBigNumber == intSmallNumber);
  }

  @Test
  void testDoubleToFloat() {
    double doubleNumber = 1.1529215e+18;
    float floatNumber = (float) doubleNumber;

    System.out.println(floatNumber);

    assertFalse(doubleNumber == floatNumber);
  }
}

