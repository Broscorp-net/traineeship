package net.broscorp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Junit5 primitives")
public class JunitPrimitives {

  private byte testByte;
  private byte result;
  private long bigLong;
  private long smallLong;
  private float testFloat;

  @BeforeAll
  void setUp() {
    testByte = 120;
    bigLong = 9223372036854775L;
    smallLong = 202777289L;
    testFloat = 18.4f;
  }

  @Test
  void whenByteOverflow() {
    testByte += 12;
  }

  @Test
  void whenLongValueIsGreaterThanMaximumValueOfInt() {
    int anInt = (int) bigLong;
    Assertions.assertNotEquals(anInt, bigLong);
  }

  @Test
  void whenLongValueIsWithinThanMaximumValueOfInt() {
    int anInt = (int) smallLong;
    Assertions.assertEquals(anInt, smallLong);
  }

  @Test
  void whenFloatCastToDouble() {
    double testDouble = testFloat;
    System.out.println("float " + testFloat + " cast to double " + testDouble);
    Assertions.assertEquals(testDouble, testFloat);
  }







}
