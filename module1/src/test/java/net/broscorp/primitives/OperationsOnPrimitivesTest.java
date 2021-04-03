package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class OperationsOnPrimitivesTest {

  //  Tests for numeric types overflow demonstration:

  //  Right results (without type overflow) of operations on numbers of byte and int types
  @Test
  void getNotOverflowResultsTest() {
    //      GIVEN:
    byte a = 20;
    byte b = 45;
    int c = Integer.MIN_VALUE;
    int d = 5000;
    //      THEN:
    assertTrue(Byte.MAX_VALUE > (byte) (a + b));
    assertTrue(Integer.MIN_VALUE < c + d);
    assertEquals(65, (byte) (a + b));
    assertEquals(-2_147_478_648, c + d);
  }

  //  An overflow of byte type as a result of operation on numbers of byte type
  @Test
  void getOverflowByteResultTest() {
    //      GIVEN:
    byte a = 120;
    byte b = 45;
    //      THEN:
    assertTrue(Byte.MAX_VALUE > (byte) (a + b));
    assertNotEquals(165, (byte) (a + b));
    assertEquals(-91, (byte) (a + b));
  }

  //  An overflow of int type as a result of operation on numbers of int type
  @Test
  void getOverflowIntResultTest() {
    //      GIVEN:
    int c = Integer.MIN_VALUE;
    int d = -5000;
    //      THEN:
    assertTrue(Integer.MIN_VALUE < c + d);
    assertNotEquals(-2_147_488_648L, c + d);
    assertEquals(2_147_478_648, c + d);
  }

  //  Tests for demonstration of converting between primitive types
  //  and the problems come from this:

  //  Right results of converting long to int and double to float
  @Test
  void getRightConvertedResultsTest() {
    //      GIVEN:
    long l = Integer.MAX_VALUE;
    float f = 4.6f;
    double d = 2.3;
    //      THEN:
    assertEquals(Integer.MAX_VALUE, (int) l);
    assertEquals(2.3f, (float) d);
    assertEquals(2.0f, (float) (f / d));
  }

  //  An overflow of int type as a result of converting long to int
  @Test
  void getOverflowWhenConvertingLongToIntTest() {
    //      GIVEN:
    long l1 = (long) Integer.MAX_VALUE + 1; // = 2_147_483_648L
    long l2 = (long) Integer.MIN_VALUE - 1; // = - 2_147_483_649L
    //      WHEN:
    int i1 = (int) l1;
    int i2 = (int) l2;
    //      THEN:
    assertNotEquals(2_147_483_648L, i1);
    assertEquals(Integer.MIN_VALUE, i1);

    assertNotEquals(-2_147_483_649L, i2);
    assertEquals(Integer.MAX_VALUE, i2);
  }

  //  Loss of number accuracy when converting float to double
  @Test
  void getLossAccuracyOfNumberWhenConvertingFloatToDoubleTest() {
    //      GIVEN:
    float f1 = 4.7f;
    float f2 = 2.2f;
    //      THEN:
    assertNotEquals(4.7, (double) f1);
    assertNotEquals(2.5, (double) (f1 - f2));
  }

  //  Tests for demonstration of floating point errors:

  //  Automatic rounding for results of arithmetic operations with int and long types
  @Test
  void getAutomaticallyRoundedIntegerResultWhenDivisionOfIntAndLongTest() {
    //      GIVEN:
    int i1 = 5;
    int i2 = 18;
    long l1 = -15L;
    long l2 = 20L;
    //      THEN:
    assertNotEquals(3.6, i2 / i1);
    assertEquals(3, i2 / i1);

    assertNotEquals(-0.75, l1 / l2);
    assertEquals(0, l1 / l2);

    assertNotEquals(-1.2, i2 / l1);
    assertEquals(-1, i2 / l1);
  }

  // The result of an arithmetic operation on floating point numbers may be inaccurate
  @Test
  void getInaccurateResultsOfArithmeticOperationOnFloatsAndDoublesTest() {
    //      GIVEN:
    float f1 = 4.7f;
    float f2 = 2.2f;
    float f3 = 6.9f;
    double d1 = 4.72;
    double d2 = 2.23;
    double d3 = 6.95;
    //      THEN:
    assertNotEquals(2.5f, f1 - f2);
    assertNotEquals(f3, f1 + f2);
    assertNotEquals(d3, d1 + d2);
    assertNotEquals(2.49, d1 - d2);
  }
}
