package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class PrimitivesTest {

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  // 8 bit [-128, 127]
  @Test
  @DisplayName("Should overflow and underflow byte")
  public void overflowAndUnderflowByte() {
    byte bytemax = Byte.MAX_VALUE;
    bytemax++;
    byte bytemin = Byte.MIN_VALUE;
    bytemin--;

    assertEquals(-128, bytemax);
    assertEquals(127, bytemin);

  }

  // 16 bit [-32768, 32767]
  @Test
  @DisplayName("Should overflow and underflow short")
  public void overflowAndUnderflowShort() {
    short shortmax = Short.MAX_VALUE;
    shortmax++;
    short shortmin = Short.MIN_VALUE;
    shortmin--;

    assertEquals(-32768, shortmax);
    assertEquals(32767, shortmin);

  }

  // 16 bit [UTF-16 \uFFFF]
  @Test
  @DisplayName("Should overflow and underflow char")
  public void overflowAndUnderflowChar() {
    char charmax = Character.MAX_VALUE;
    charmax++;
    char charmin = Character.MIN_VALUE;
    charmin--;

    assertEquals('\u0000', charmax);
    assertEquals('\uFFFF', charmin);

  }

  // 32 bit [-2147483648, 2147483647]
  @Test
  @DisplayName("Should overflow and underflow int")
  public void overflowAndUnderflowInt() {
    int intmax = Integer.MAX_VALUE;
    intmax++;
    int intmin = Integer.MIN_VALUE;
    intmin--;

    assertEquals(-2147483648, intmax);
    assertEquals(2147483647, intmin);

  }

  // 64 bit [-9223372036854775808L, 9223372036854775807L]
  @Test
  @DisplayName("Should overflow and underflow long")
  public void overflowAndUnderflowLong() {
    long longmax = Long.MAX_VALUE;
    longmax++;
    long longmin = Long.MIN_VALUE;
    longmin--;

    assertEquals(-9223372036854775808L, longmax);
    assertEquals(9223372036854775807L, longmin);

  }

  // 32 bit [1.4e-45f, 3.4e+38f]
  @Test
  @DisplayName("Should overflow and underflow float")
  public void overflowAndUnderflowFloat() {
    float floatmax = Float.MAX_VALUE;
    floatmax += Float.MAX_VALUE;
    float floatmin = - Float.MAX_VALUE;
    floatmin -= Float.MAX_VALUE;

    float floatmaxzero = Float.MIN_VALUE;
    floatmaxzero -= Float.MIN_VALUE;
    float floatminzero = - Float.MIN_VALUE;
    floatminzero += Float.MIN_VALUE;

    assertEquals(Float.POSITIVE_INFINITY, floatmax);
    assertEquals(Float.NEGATIVE_INFINITY, floatmin);
    assertEquals(0.0, floatmaxzero);
    assertEquals(0.0, floatminzero);


  }

  // 64 bit [4.9e-324, 1.7e+308]
  @Test
  @DisplayName("Should overflow and underflow double")
  public void overflowAndUnderflowDouble() {
    double doublemax = Double.MAX_VALUE;
    doublemax += Double.MAX_VALUE;
    double doublemin = - Double.MAX_VALUE;
    doublemin -= Double.MAX_VALUE;

    double doublemaxzero = Double.MIN_VALUE;
    doublemaxzero -= Double.MIN_VALUE;
    double doubleminzero = - Double.MIN_VALUE;
    doubleminzero += Double.MIN_VALUE;

    assertEquals(Double.POSITIVE_INFINITY, doublemax);
    assertEquals(Double.NEGATIVE_INFINITY, doublemin);
    assertEquals(0.0, doublemaxzero);
    assertEquals(0.0, doubleminzero);

  }


  @Test
  @DisplayName("Should throw ArithmeticException for integer")
  public void shouldArithmeticExceptionForInt() {

    assertThrows(ArithmeticException.class, () -> Math.incrementExact(Integer.MAX_VALUE));
    assertThrows(ArithmeticException.class, () -> Math.decrementExact(Integer.MIN_VALUE));

  }

  @Test
  @DisplayName("Should throw ArithmeticException for long")
  public void shouldArithmeticExceptionForLong() {

    assertThrows(ArithmeticException.class, () -> Math.incrementExact(Long.MAX_VALUE));
    assertThrows(ArithmeticException.class, () -> Math.decrementExact(Long.MIN_VALUE));

  }


  // Narrowing Casting (manually) - converting a larger type to a smaller size type
  // If variable long_value > Integer.MAX_VALUE  or < Integer.MIN_VALUE then Overflow or Underflow
  // If variable long_value <= Integer.MAX_VALUE or >= Integer.MIN_VALUE then all OK
  @Test
  @DisplayName("Should narrowing casting long to integer")
  public void shouldNarrowingCastingLongToInt() {
    long lessminint = Integer.MIN_VALUE - 1; // -2147483649L;
    long moremaxint = Integer.MAX_VALUE + 1; // 2147483648L;
    long maxint = Integer.MAX_VALUE;     // 2147483647L;
    long minint = Integer.MIN_VALUE;     // -2147483648L;
    long lessmaxint = Integer.MAX_VALUE - 1;     // 2147483646L;
    long moreminint = Integer.MIN_VALUE + 1;     // -2147483647L;


    final int i1 = (int) lessminint;
    final int i2 = (int) moremaxint;
    final int i3 = (int) maxint;
    final int i4 = (int) minint;
    final int i5 = (int) lessmaxint;
    final int i6 = (int) moreminint;

    assertEquals(2147483647, i1);
    assertEquals(-2147483648, i2);
    assertEquals(2147483647, i3);
    assertEquals(-2147483648, i4);
    assertEquals(2147483646, i5);
    assertEquals(-2147483647, i6);


  }

  // Widening Casting (automatically) - converting a smaller type to a larger type size
  @Test
  @DisplayName("Should widening casting float to double")
  public void shouldWideningCastingFloatToDouble() {

    float floatmax = Float.MAX_VALUE;
    float floatmin = - Float.MAX_VALUE;
    float floatmaxzero = Float.MIN_VALUE;
    float floatminzero =  - Float.MIN_VALUE;
    final double d1 = floatmax;
    final double d2 = floatmin;
    final double d3 = floatmaxzero;
    final double d4 = floatminzero;


    assertEquals(Float.MAX_VALUE, d1);
    assertEquals(-Float.MAX_VALUE, d2);
    assertEquals(Float.MIN_VALUE, d3);
    assertEquals(-Float.MIN_VALUE, d4);


  }


  // Float and double are bad for financial world, never use them for monetary calculations.
  // Use comparison within a range, that is, if the diff of the float to the number you want
  // to compare it to is less than a certain absolute value.
  @Test
  @DisplayName("Should consider accuracy class for float and double")
  public void shouldConsiderAccuracyClass() {
    float f1 = 0.3F + 0.4F;
    float f2 = 0.7F;
    float f3 = 0.9F;
    double d1 = 0.9;

    assertNotEquals(f2, f1);
    assertNotEquals(d1, f3);

    assertTrue(Math.abs(f1 - f2) < 1e-5);
    assertTrue(Math.abs(d1 - f3) < 1e-5);

  }


}
