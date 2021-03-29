package net.broscorp.override.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathOperationImplAdditionTest {

  private final MathOperation mathOperationAdd = new MathOperationImplAddition();
  private double expected;

  @BeforeEach
  void init() {
    expected = 22 + 45;
  }

  @Test
  void methodIntTest() {
    int first = 22;
    int second = 45;
    Assertions.assertEquals(expected, mathOperationAdd.method(first, second));
  }

  @Test
  void methodDouTest() {
    double first = 22.0;
    double second = 45.0;
    Assertions.assertEquals(expected, mathOperationAdd.method(first, second));
  }

  @Test
  void methodIntegerTest() {
    Integer first = 22;
    Integer second = 45;
    Assertions.assertEquals(expected, mathOperationAdd.method(first, second));
  }

  @Test
  void methodDoubleTest() {
    Double first = 22.0;
    Double second = 45.0;
    Assertions.assertEquals(expected, mathOperationAdd.method(first, second));
  }

  /**
   * The method method(double, double) will be called.
   */
  @Test
  void methodDouIntegerTest() {
    double first = 22.0;
    Integer second = 45;
    Assertions.assertEquals(expected, mathOperationAdd.method(first, second));
  }

  /**
   * The method method(double, double) will be called.
   */
  @Test
  void methodDouIntTest() {
    int first = 22;
    double second = 45.0;
    Assertions.assertEquals(expected, mathOperationAdd.method(first, second));
  }

  /**
   * The method method(double, double) will be called.
   */
  @Test
  void methodIntDoubleTest() {
    int first = 22;
    Double second = 45.0;
    Assertions.assertEquals(expected, mathOperationAdd.method(first, second));
  }

}
