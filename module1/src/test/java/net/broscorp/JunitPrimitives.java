package net.broscorp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Junit5 primitives")
public class JunitPrimitives {

  @Test
  void whenByteOverflow() {
    byte actual = 120;
    byte expected = -124;
    actual += 12;
    Assertions.assertSame(expected, actual);
  }

  @Test
  void whenLongValueIsGreaterThanMaximumValueOfInt() {
    long bigLong = 9223372036854775L;
    int anInt = (int) bigLong;
    Assertions.assertNotEquals(anInt, bigLong);
  }

  @Test
  void whenLongValueIsWithinThanMaximumValueOfInt() {
    long smallLong = 202777289L;
    int anInt = (int) smallLong;
    Assertions.assertEquals(anInt, smallLong);
  }

  @Test
  void whenFloatCastToDouble() {
    float testFloat = 18.4f;
    double testDouble = testFloat;
    System.out.println("float " + testFloat + " cast to double " + testDouble);
    Assertions.assertEquals(testDouble, testFloat);
  }

  @Test
  void floatingPointError() {
    double actual = 2.0 - 1.1;
    double expected = 0.8999999999999999;
    Assertions.assertEquals(expected, actual);
  }

}
