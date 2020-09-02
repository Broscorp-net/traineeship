package broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class WrappersTest {

  @Test
  // в пределах кеша получаем тот же обьект
  void wrappersCompare_v1() {
    Integer number1 = 100;
    Integer number2 = 100;
    assertSame(number1, number2);
  }

  @Test
  // за пределами кеша объекты разные
  void wrappersCompare_v2() {
    Integer number1 = 1000;
    Integer number2 = 1000;
    assertNotSame(number1, number2);
  }

  @Test
  void compareWithCasting() {
    int number1 = 1000;
    Integer obj1 = number1;
    Integer obj2 = number1;
    assertNotSame(obj1, obj2);
  }
}
