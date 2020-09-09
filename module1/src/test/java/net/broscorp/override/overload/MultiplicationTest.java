package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MultiplicationTest {

  @Test
  void applyOperationToTwoDoublePrimitives() {
    MathOperation mul = new Multiplication();
    double expectedResult = 0.0625;
    double firstParam = 0.25;
    double secondParam = 0.25;

    double actualResult = mul.apply(firstParam, secondParam);

    assertEquals(expectedResult, actualResult);
  }

  @Test
  void applyOperationToTwoIntegerPrimitives() {
    MathOperation mul = new Multiplication();
    double expectedResult = 100.0;
    int firstParam = 5;
    int secondParam = 20;

    double actualResult = mul.apply(firstParam, secondParam);

    assertEquals(expectedResult, actualResult);
  }

  @Test
  void applyOperationToTwoDoubleWrappers() {
    MathOperation mul = new Multiplication();
    double expectedResult = -27.72;
    Double firstParam = 13.2;
    Double secondParam = -2.1;

    double actualResult = mul.apply(firstParam, secondParam);

    assertEquals(expectedResult, actualResult);
  }

  @Test
  void applyOperationToTwoIntegerWrappers() {
    MathOperation mul = new Multiplication();
    double expectedResult = 0.0;
    Integer firstParam = -2901;
    Integer secondParam = 0;

    double actualResult = mul.apply(firstParam, secondParam);

    assertEquals(expectedResult, actualResult);
  }

  /**
   * Calls {@code double apply(double d1, double d2)} because supplied parameters fit best to this
   * signature.
   */
  @Test
  void applyOperationToIntegerPrimitiveAndDoubleWrapper() {
    MathOperation mul = new Multiplication();
    double expectedResult = -2.24;
    int firstParam = 4;
    Double secondParam = -0.56;

    double actualResult = mul.apply(firstParam, secondParam);

    assertEquals(expectedResult, actualResult);
  }

  /**
   * Calls {@code double apply(double d1, double d2)} because supplied parameters fit best to this
   * signature.
   */
  @Test
  void applyOperationToDoublePrimitiveAndIntegerWrapper() {
    MathOperation mul = new Multiplication();
    double expectedResult = -2.24;
    double firstParam = -0.56;
    Integer secondParam = 4;

    double actualResult = mul.apply(firstParam, secondParam);

    assertEquals(expectedResult, actualResult);
  }

  /**
   * When trying to apply operation to primitive double and wrapper Double, compiler says
   * that it's an ambiguous method call (there are 2 methods that can be called:
   * 'double apply(double d1, double d2)' and 'double apply(Double d1, Double d2)').
   * It's exactly the same for int and Integer too (there are again 2 methods that
   * can be called: 'double apply(int i1, int i2)' and 'double apply(Integer i1, Integer i2)').
   */
  //  @Test
  //  void applyOperationToDoublePrimitiveAndDoubleWrapper() {
  //    MathOperation mul = new Multiplication();
  //    double expectedResult = 2.0;
  //    double firstParam = 1.0;
  //    Double secondParam = 2.0;
  //
  //    double actualResult = mul.apply(firstParam, secondParam);
  //
  //    assertEquals(expectedResult, actualResult);
  //  }

}
