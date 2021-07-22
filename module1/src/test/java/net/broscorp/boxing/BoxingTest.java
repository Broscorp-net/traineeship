package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BoxingTest {

  /**
   * 1. Comparing two wrapper types using == returns true.
   */

  @ParameterizedTest
  @ValueSource(ints = {20, 30, -100, 500000, Integer.MAX_VALUE, Integer.MIN_VALUE})
  void testEqualsOperandShouldReturnTrue(int i) {
    Integer a = i;
    Integer b = a;
    assertTrue(a == b);
  }

  /**
   * If the number assigned to wrapper class is within Byte range it is implicitly pooled(cached) by
   * Java. Numbers exceeding the limit are not pooled.
   */

  @ParameterizedTest
  @ValueSource(ints = {Byte.MAX_VALUE, Byte.MIN_VALUE, 10, 20, 30, 90, 111})
  void testDespiteDifferentObjectEqualityOperandReturnsTrue(int i) {
    Integer a = i;
    Integer b = i;
    assertTrue(a == b);
  }

  /**
   * 2. Comparing two wrapper types using == returns false
   */

  @ParameterizedTest
  @ValueSource(ints = {200, 300, -1000, 500000, Integer.MAX_VALUE, Integer.MIN_VALUE})
  void testEqualsOperandShouldReturFase(int i) {
    Integer a = i;
    Integer b = i;
    assertFalse(a == b);
  }

  @ParameterizedTest
  @ValueSource(floats = {10.2f, 512, 2356f, Float.MAX_VALUE, Float.MIN_VALUE})
  void testComparingShouldReturnFalse(float fl) {
    Double d = 10.2;
    Double d2 = (double) fl;
    assertFalse(d == d2);
  }

  @ParameterizedTest
  @ValueSource(ints = {1000, 500, 959595})
  void testComparingShouldReturnFalse(int i) {
    Integer a = i;
    Integer b = Integer.valueOf(i);
    assertFalse(a == b);
  }

  /**
   * Implicit unboxing causes exception
   */

  @Test
  void testThrowsNPE() {
    Integer num = null;
    assertThrows(NullPointerException.class, () -> {
      int i = num;
    });
  }

  @Test
  void testThrowsArithmeticException() {
    Integer num = 15000;
    assertThrows(ArithmeticException.class, () -> {
      int i = num / 0;
    });
  }


}
