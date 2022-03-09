package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  void overflowTest() {
    // при а выходящих за пределы Integer тест будет не пройден из-за переполнения
    long a = Integer.MAX_VALUE;
    int b = (int) a;
    Assertions.assertEquals(b,a);
  }

  @Test
  void convertTest() {
    // по преобразованию long в int см. метод overflowTest()
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
