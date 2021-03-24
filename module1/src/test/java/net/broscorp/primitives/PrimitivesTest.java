package net.broscorp.primitives;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Hryhorii Perets
 */
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
    byte bMax = Byte.MAX_VALUE;
    bMax ++;
    byte bMin = Byte.MIN_VALUE;
    bMin --;

    assertEquals(-128, bMax);
    assertEquals(127, bMin);

  }

  // 16 bit [-32768, 32767]
  @Test
  @DisplayName("Should overflow and underflow short")
  public void overflowAndUnderflowShort() {
    short sMax = Short.MAX_VALUE;
    sMax ++;
    short sMin = Short.MIN_VALUE;
    sMin --;

    assertEquals(-32768, sMax);
    assertEquals(32767, sMin);

  }

  // 16 bit [UTF-16 \uFFFF]
  @Test
  @DisplayName("Should overflow and underflow char")
  public void overflowAndUnderflowChar() {
    char cMax = Character.MAX_VALUE;
    cMax ++;
    char cMin = Character.MIN_VALUE;
    cMin --;

    assertEquals('\u0000', cMax);
    assertEquals('\uFFFF', cMin);

  }

  // 32 bit [-2147483648, 2147483647]
  @Test
  @DisplayName("Should overflow and underflow int")
  public void overflowAndUnderflowInt() {
    int iMax = Integer.MAX_VALUE;
    iMax ++;
    int iMin = Integer.MIN_VALUE;
    iMin --;

    assertEquals(-2147483648, iMax);
    assertEquals(2147483647, iMin);

  }

  // 64 bit [-9223372036854775808L, 9223372036854775807L]
  @Test
  @DisplayName("Should overflow and underflow long")
  public void overflowAndUnderflowLong() {
    long lMax = Long.MAX_VALUE;
    lMax ++;
    long lMin = Long.MIN_VALUE;
    lMin --;

    assertEquals(-9223372036854775808L, lMax);
    assertEquals(9223372036854775807L, lMin);

  }

  // 32 bit [1.4e-45f, 3.4e+38f]
  @Test
  @DisplayName("Should overflow and underflow float")
  public void overflowAndUnderflowFloat() {
    float fMax = Float.MAX_VALUE;
    fMax += Float.MAX_VALUE;
    float fMin = - Float.MAX_VALUE;
    fMin -= Float.MAX_VALUE;

    float fMaxZero = Float.MIN_VALUE;
    fMaxZero -= Float.MIN_VALUE;
    float fMinZero = - Float.MIN_VALUE;
    fMinZero += Float.MIN_VALUE;

    assertEquals(Infinity, fMax);
    assertEquals(- Infinity, fMin);
    assertEquals(0.0, fMaxZero);
    assertEquals(0.0, fMinZero);


  }

  // 64 bit [4.9e-324, 1.7e+308]
  @Test
  @DisplayName("Should overflow and underflow double")
  public void overflowAndUnderflowDouble() {
    double dMax = Double.MAX_VALUE;
    dMax += Double.MAX_VALUE;
    double dMin = - Double.MAX_VALUE;
    dMin -= Double.MAX_VALUE;

    double dMaxZero = Double.MIN_VALUE;
    dMaxZero -= Double.MIN_VALUE;
    double dMinZero = - Double.MIN_VALUE;
    dMinZero += Double.MIN_VALUE;

    assertEquals(Infinity, dMax);
    assertEquals(-Infinity, dMin);
    assertEquals(0.0, dMaxZero);
    assertEquals(0.0, dMinZero);

  }


  @Test
  @DisplayName("Should throw ArithmeticException for int")
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

}
