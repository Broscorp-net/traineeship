package net.broscorp.f_boxing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class F_wrapperTest {

  /**
   * In this test I compare two Integer Objects, which is allocated in different heap area places.
   * Test will show us falls. But this is not works for numbers less than 128.
   */
  @Test
  void testEquality() {
    Integer a = 500;
    Integer b = 500;
    assertTrue(a == b);
  }

  /**
   * В этом тесте я явно запаковываю примитив в обертку, и убеждаюсь что это уже екземпляр класс
   * Integer. Для примитивов, этот тест покажет ошибку еще на этапе компиляции.
   */
  @Test
  void testAutoboxing() {
    int b = 0;
    assertTrue(Integer.valueOf(b) instanceof Integer);
  }

  /**
   * В этом тесте я явно распаковываю обьект Integer, и делаю сравнение между примитивами.
   */
  @Test
  void testAutounboxing() {
    Integer c = 500;
    Integer b = 500;
    assertTrue(c.intValue() == b.intValue());
  }

}
