package net.broscorp.override.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RealizationAddsTest {
  private static final MathOperation operation = new RealizationAdds();

  @Test
  void addsPrimitiveInt() {
    Assertions.assertEquals(10, operation.operation(2, 8));
  }

  @Test
  void addsPrimitiveDouble() {
    Assertions.assertEquals(10, operation.operation(2.5, 7.5));
  }

  @Test
  void addsInteger() {
    Integer a = new Integer(2);
    Integer b = new Integer(8);
    Assertions.assertEquals(10, operation.operation(a, b));
  }

  @Test
  void addsDouble() {
    Double a = new Double(2.5);
    Double b = new Double(7.5);
    Assertions.assertEquals(10, operation.operation(a, b));
  }

  //Здесь возникает ошибка "reference to operation is ambiguous".
  //Программа не понимает какую перегрузку метода нужно вызвать.
/*
  @Test
  void addsPrimitiveAndWrapper() {
    Integer a = new Integer(2);
    int b = 8;
    Assertions.assertEquals(10, operation.operation(a, b));
  }
*/
}