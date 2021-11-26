package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MathOperationMultiplyTest {

  MathOperationMultiply mathOperationMultiply = new MathOperationMultiply();

  @Test
  void twoDoublesPrimitiveDouble() {
    double a = 1.5;
    double b = 2.0;

    double res = mathOperationMultiply.twoDoubles(a, b);
    assertEquals(3.0, res);
  }

  @Test
  void twoDoublesPrimitiveInt() {
    int a = 5;
    int b = 3;

    double res = mathOperationMultiply.twoDoubles(a, b);
    assertEquals(15.0, res);
  }

  @Test
  void twoDoublesObjectsInt() {
    Integer a = 3;
    Integer b = 2;

    double res = mathOperationMultiply.twoDoubles(a, b);
    assertEquals(6.0, res);
  }

  /***
   * <p>При вызове метода с не определенными параметрами (например int a, Integer b)
   * компилятор выдаст ошибку, что не знает переопределенного метода с такими параметрами
   * и предложит переопределить такой метод.</p>
   */
}