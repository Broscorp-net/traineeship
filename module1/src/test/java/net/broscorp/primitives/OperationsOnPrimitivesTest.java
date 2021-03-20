package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class OperationsOnPrimitivesTest {

  OperationsOnPrimitives testOperationsOnPrimitives = new OperationsOnPrimitives();

  //  Tests for numeric types overflow demonstration:

  @Test
  void shouldNotBeOverflowAfterGetSameTypeResultBinaryMethodTest() {
    //      GIVEN:
    byte a = 20, b = 45;
    int c = Integer.MIN_VALUE, d = 5000;
    BinaryOperator<Byte> sumByteOperator = (x, y) -> (byte) (x + y);
    BinaryOperator<Integer> sumIntOperator = Integer::sum;
    //      WHEN:
    byte correctSumByteResult =
        testOperationsOnPrimitives.getSameTypeResultBinaryMethod(a, b, sumByteOperator);
    int correctSumIntResult =
        testOperationsOnPrimitives.getSameTypeResultBinaryMethod(c, d, sumIntOperator);
    //      THEN:
    Assertions.assertTrue(Byte.MAX_VALUE > correctSumByteResult);
    Assertions.assertTrue(Integer.MIN_VALUE < correctSumIntResult);

    Assertions.assertEquals(65, correctSumByteResult);
    Assertions.assertEquals(-2_147_478_648, correctSumIntResult);
  }

  @Test
  void shouldBeByteResultOverflowAfterGetSameTypeResultBinaryMethodTest() {
    //      GIVEN:
    byte a = 120, b = 45;
    BinaryOperator<Byte> sumByteOperator = (x, y) -> (byte) (x + y);
    //      WHEN:
    byte overflowingSumByteResult =
        testOperationsOnPrimitives.getSameTypeResultBinaryMethod(a, b, sumByteOperator);
    //      THEN:
    Assertions.assertTrue(Byte.MAX_VALUE > overflowingSumByteResult);
    Assertions.assertNotEquals(165, overflowingSumByteResult);
    Assertions.assertEquals(-91, overflowingSumByteResult);
  }

  @Test
  void shouldBeIntResultOverflowAfterGetSameTypeResultBinaryMethodTest() {
    //      GIVEN:
    int c = Integer.MIN_VALUE, d = -5000;
    BinaryOperator<Integer> sumIntOperator = Integer::sum;
    //      WHEN:
    int overflowingSumIntResult =
        testOperationsOnPrimitives.getSameTypeResultBinaryMethod(c, d, sumIntOperator);
    //      THEN:
    Assertions.assertTrue(Integer.MIN_VALUE < overflowingSumIntResult);
    Assertions.assertNotEquals(-2_147_488_648L, overflowingSumIntResult);
    Assertions.assertEquals(2_147_478_648, overflowingSumIntResult);
  }

  //  Tests for demonstration of converting between primitive types and the problems arising from
  // this:

  @Test
  void shouldBeClearlyConvertedResultsOfGetOtherTypeResultUnaryMethodTest() {
    //      GIVEN:
    long l = Integer.MAX_VALUE;
    float f = 4.6f;
    double d = 2.3;
    Function<Long, Integer> longToIntConverter = (x) -> (int) x.longValue();
    Function<Float, Double> floatToDoubleConverter = Float::doubleValue;
    Function<Double, Float> doubleToFloatConverter = Double::floatValue;
    //      WHEN:
    int longToIntConvertResult =
        testOperationsOnPrimitives.getOtherTypeResultUnaryMethod(l, longToIntConverter);
    double floatToDoubleConvertResult =
        testOperationsOnPrimitives.getOtherTypeResultUnaryMethod(
            (float) (f / d), floatToDoubleConverter);
    float doubleToFloatConvertResult =
        testOperationsOnPrimitives.getOtherTypeResultUnaryMethod(d, doubleToFloatConverter);
    //      THEN:
    Assertions.assertEquals(l, longToIntConvertResult);
    Assertions.assertEquals(2.0, floatToDoubleConvertResult);
    Assertions.assertEquals(2.3f, doubleToFloatConvertResult);
  }

  @Test
  void shouldBeCuriouslyConvertedResultsOfGetOtherTypeResultUnaryMethodTest() {
    //      GIVEN:
    int i1 = 5, i2 = -5;
    long l1 = 18L, l2 = 20L;
    Function<Long, Integer> longToIntConverter = (x) -> (int) x.longValue();
    Function<Integer, Long> intToLongConverter = (x) -> (long) x;
    //      WHEN:
    int longToIntConvertResult =
        testOperationsOnPrimitives.getOtherTypeResultUnaryMethod(l1 / i1, longToIntConverter);
    long intToLongConvertResult =
        testOperationsOnPrimitives.getOtherTypeResultUnaryMethod(
            (int) (i2 / l2), intToLongConverter);
    //      THEN:
    Assertions.assertNotEquals(3.6, longToIntConvertResult);
    Assertions.assertEquals(3, longToIntConvertResult);

    Assertions.assertNotEquals(-0.25, intToLongConvertResult);
    Assertions.assertEquals(0, intToLongConvertResult);
  }

  //  Test for demonstration of floating point errors:

  @Test
  void shouldBeDiffsOfConvertedFloatingPointValuesAfterGetOtherTypeResultUnaryMethodTest() {
    //      GIVEN:
    float f1 = 4.6f, f2 = 2.3f;
    double d1 = 4.6, d2 = 2.3;
    Function<Float, Double> floatToDoubleConverter = (x) -> (double) x;
    Function<Double, Float> doubleToFloatConverter = Double::floatValue;
    //      WHEN:
    double floatToDoubleConvertResult1 =
        testOperationsOnPrimitives.getOtherTypeResultUnaryMethod(f1, floatToDoubleConverter);
    double floatToDoubleConvertResult2 =
        testOperationsOnPrimitives.getOtherTypeResultUnaryMethod(f1 - f2, floatToDoubleConverter);
    float doubleToFloatConvertResult =
        testOperationsOnPrimitives.getOtherTypeResultUnaryMethod(d1 - d2, doubleToFloatConverter);
    //      THEN:
    Assertions.assertNotEquals(4.6, floatToDoubleConvertResult1);

    Assertions.assertEquals(2.3f, doubleToFloatConvertResult);
    Assertions.assertNotEquals(2.3, floatToDoubleConvertResult2);
    Assertions.assertEquals(doubleToFloatConvertResult, floatToDoubleConvertResult2);
  }
}
