package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  void overflowTest() {
    int a = Integer.MAX_VALUE;
    int b = 555;
    int c = Integer.MIN_VALUE;
    c += b - 1;
    b += a;
    // При переполнении переменная не становиться равной Integer.MAX_VALUE
    Assertions.assertNotEquals(b,a);
    /* А меняет свое значение, после Integer.MAX_VALUE следующим идет Integer.MIN_VALUE,
    а следующие значения прибавляются к нему.
    */
    Assertions.assertEquals(c,b);
  }

  @Test
  void convertLongIntTest() {
    /* если переменная long > переменной int происходит потеря значения преобразуемой переменной
    из-за переполнения int, описанного в методе overflowTest()
    */
    long a = Integer.MAX_VALUE + 789L;
    int b = (int) a;
    Assertions.assertNotEquals(b,a);
  }

  @Test
  void convertDoubleFloatTest() {
    // если переменная double > переменной float происходит урезание double до Float.MAX_VALUE
    double c = Float.MAX_VALUE + 555.555;
    float d;
    d = (float) c;
    Assertions.assertEquals(c,d);
  }

  @Test
  void errCountTest() {
    // это только иллюстрация, где с-точность сравнения
    double a = 0.5;
    double b = 0.01;
    double c = 0.011;
    for (int i = 0; i < 50; i++) {
      b += 0.01;
    }
    Assertions.assertTrue(Math.abs(a - b) < c);
  }
}
