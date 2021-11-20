package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  void shortOverflowIsNegativeTest() {
    short actual = Short.MIN_VALUE;
    assertEquals(Primitives.minShort(), actual);
  }

  @Test
  void shortOverflowIsPositiveTest() {
    short actual = Short.MAX_VALUE;
    assertEquals(actual, Primitives.maxShort());
  }

  @Test
  void intOverflowIsNegativeTest() {
    int actual = Integer.MIN_VALUE;
    assertEquals(actual, Primitives.minInt());
  }

  @Test
  void intOverflowIsPositiveTest() {
    int actual = Integer.MAX_VALUE;
    assertEquals(actual, Primitives.maxInt());
  }

  @Test
  void longOverflowIsNegativeTest() {
    long actual = Long.MIN_VALUE;
    assertEquals(actual, Primitives.minLong());
  }

  @Test
  void longOverflowIsPositiveTest() {
    long actual = Long.MAX_VALUE;
    assertEquals(actual, Primitives.maxLong());
  }

  @Test
  void convertLongToIntTest() {
    long l = 2147483650L;
    ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
      Primitives.convertLongToInt(l);
      throw new ArithmeticException("l value (long) maximum size i value (int) ");
    });
    Assertions.assertEquals("l value (long) maximum size i value (int) ", exception.getMessage());
  }

  @Test
  void convertMinLongToIntTest() {
    long l = Integer.MIN_VALUE;
    Primitives.convertLongToInt(l);
    assertEquals(-2147483648, Primitives.convertLongToInt(l));
  }

  @Test
  void convertMaxLongToIntTest() {
    long l = Integer.MAX_VALUE;
    Primitives.convertLongToInt(l);
    assertEquals(2147483647, Primitives.convertLongToInt(l));
  }

  @Test
  void convertFloatToDoubleTest() {
    float f = Float.MAX_VALUE;
    assertEquals(f, Primitives.convertFloatToDouble(f));
  }

  @Test
  void errorCalculationFloatAndDoubleTest() {
    double d = 2974815.78;
    double res = Primitives.errorCalculationFloatAndDouble(d);
    assertEquals(0.029999999795109034, res);
  }

  @Test
  void workingWithBigDecimalTest() {
    double d = 111.55555;
    assertEquals(111.55, Primitives.workingWithBigDecimal(d));
  }

}
