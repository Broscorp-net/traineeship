package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AdditionTest {

  @Test
  void applyOperationToTwoDoublePrimitives() {
    MathOperation add = new Addition();
    double expectedResult = 10.0;
    double firstParam = 7.56;
    double secondParam = 2.44;

    double actualResult = add.apply(firstParam, secondParam);

    assertEquals(expectedResult, actualResult);
  }

  @Test
  void applyOperationToTwoIntegerPrimitives() {
    MathOperation add = new Addition();
    double expectedResult = 5603.0;
    int firstParam = 2600;
    int secondParam = 3003;

    double actualResult = add.apply(firstParam, secondParam);

    assertEquals(expectedResult, actualResult);
  }

  @Test
  void applyOperationToTwoDoubleWrappers() {
    MathOperation add = new Addition();
    double expectedResult = 5603.01;
    Double firstParam = 2600.37;
    Double secondParam = 3002.64;

    double actualResult = add.apply(firstParam, secondParam);

    assertEquals(expectedResult, actualResult);
  }

  @Test
  void applyOperationToTwoIntegerWrappers() {
    MathOperation add = new Addition();
    double expectedResult = -2901.0;
    Integer firstParam = -2901;
    Integer secondParam = 0;

    double actualResult = add.apply(firstParam, secondParam);

    assertEquals(expectedResult, actualResult);
  }

  /**
   * Calls {@code double apply(double d1, double d2)} because supplied parameters fit best to this
   * signature.
   */
  @Test
  void applyOperationToIntegerPrimitiveAndDoubleWrapper() {
    MathOperation add = new Addition();
    double expectedResult = -2901.56;
    int firstParam = -2901;
    Double secondParam = -0.56;

    double actualResult = add.apply(firstParam, secondParam);

    assertEquals(expectedResult, actualResult);
  }

  /**
   * Calls {@code double apply(double d1, double d2)} because supplied parameters fit best to this
   * signature.
   */
  @Test
  void applyOperationToDoublePrimitiveAndIntegerWrapper() {
    MathOperation add = new Addition();
    double expectedResult = -2900.56;
    double firstParam = 1.44;
    Integer secondParam = -2902;

    double actualResult = add.apply(firstParam, secondParam);

    assertEquals(expectedResult, actualResult);
  }

}
