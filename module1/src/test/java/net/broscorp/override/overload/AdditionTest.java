package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AdditionTest {

  Addition addition = new Addition();
  double d1 = 10.0;
  double d2 = 100.0;
  int i1 = 10;
  int i2 = 100;
  double expect = 110.0;


  @Test
  void calculate() {
    double result = addition.calculate(d1, d2);
    assertEquals(expect, result);
  }

  @Test
  void testCalculate() {
    double result = addition.calculate((Double) d1, (Double) d2);
    assertEquals(expect, result);
  }

  @Test
  void testCalculate1() {
    double result = addition.calculate(i1, i2);
    assertEquals(expect, result);
  }

  @Test
  void testCalculate2() {
    double result = addition.calculate((Integer) i1, (Integer) i2);
    assertEquals(expect, result);
  }

  // вызывается calculate(double d1, double d2)
  // если возможно идет преобразование к примитивам, а не оберткам
  @Test
  void testCalculate3() {
    double result = addition.calculate(10, 100L);
    assertEquals(expect, result);
  }

  // не компилируется. java не может решить какой из аргументов нужно преобразовать
  // и какой в итоге метод вызвать
  /*  @Test
  void testCalculate4() {
    double result = addition.calculate((Integer) i1, i2);
    assertEquals(expect, result);
  }*/

}