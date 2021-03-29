package net.broscorp.override.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathOperationImplMultiplicationTest {

  private final MathOperation mathOperationAdd = new MathOperationImplMultiplication();
  private double expected;

  @BeforeEach
  void init() {
    expected = 13 * 27;
  }

  @Test
  void methodIntTest() {
    int first = 13;
    int second = 27;
    Assertions.assertEquals(expected, mathOperationAdd.method(first, second));
  }

  @Test
  void methodDouTest() {
    double first = 13.0;
    double second = 27.0;
    Assertions.assertEquals(expected, mathOperationAdd.method(first, second));
  }

  @Test
  void methodIntegerTest() {
    Integer first = 13;
    Integer second = 27;
    Assertions.assertEquals(expected, mathOperationAdd.method(first, second));
  }

  @Test
  void methodDoubleTest() {
    Double first = 13.0;
    Double second = 27.0;
    Assertions.assertEquals(expected, mathOperationAdd.method(first, second));
  }

  /**
   * The method method(double, double) will be called.
   */
  @Test
  void methodDouIntegerTest() {
    double first = 13.0;
    Integer second = 27;
    Assertions.assertEquals(expected, mathOperationAdd.method(first, second));
  }

  /**
   * The method method(double, double) will be called.
   */
  @Test
  void methodDouIntTest() {
    int first = 13;
    double second = 27.0;
    Assertions.assertEquals(expected, mathOperationAdd.method(first, second));
  }

  /**
   * The method method(double, double) will be called.
   */
  @Test
  void methodIntDoubleTest() {
    int first = 13;
    Double second = 27.0;
    Assertions.assertEquals(expected, mathOperationAdd.method(first, second));
  }

}
