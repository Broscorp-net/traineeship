package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AdditionTest {

  Addition addition = new Addition();

  @Test
  void doublePrimitivesAdditionTest() {
    double d1 = 10.0;
    double d2 = 100.0;
    double expect = 110.0;
    double result = addition.calculate(d1, d2);
    assertEquals(expect, result);
  }

  @Test
  void doublePrimitivesAdditionWithCastingTest() {
    double d1 = 10.0;
    double d2 = 100.0;
    double expect = 110.0;
    double result = addition.calculate((Double) d1, (Double) d2);
    assertEquals(expect, result);
  }

  @Test
  void intPrimitivesAdditionTest() {
    int i1 = 10;
    int i2 = 100;
    double expect = 110.0;
    double result = addition.calculate(i1, i2);
    assertEquals(expect, result);
  }

  @Test
  void intPrimitivesAdditionWithCastingTest() {
    int i1 = 10;
    int i2 = 100;
    double expect = 110.0;
    double result = addition.calculate((Integer) i1, (Integer) i2);
    assertEquals(expect, result);
  }

  // вызывается calculate(double d1, double d2)
  // если возможно идет преобразование к примитивам, а не оберткам
  @Test
  void doubleAndlongPrimitivesAdditionTest() {
    double expect = 110.0;
    double result = addition.calculate(10, 100L);
    assertEquals(expect, result);
  }

  // не компилируется. java не может решить какой из аргументов нужно преобразовать
  // и какой в итоге метод вызвать
  /*  @Test
  void intPrimitivesAdditionWithCastingOnlyOneParameterTest() {
    double expect = 110.0;
    double result = addition.calculate((Integer) i1, i2);
    assertEquals(expect, result);
  }*/

}