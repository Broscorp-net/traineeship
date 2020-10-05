package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BoxingTest {


  //Написать тест, в котором сравнение двух оберточных
  // типов с одинаковым значением через == даёт true.
  @Test
  void compareWrappersIntegerGivesTrue() {
    Integer a = 100;
    Integer b = 100;
    assertTrue(a == b);
  }

  @Test
  void compareWrappersShortGivesTrue() {
    Short a = 100;
    Short b = 100;
    assertTrue(a == b);
  }

  //Написать тест, в котором сравнение двух оберточных
  // типов с одинаковым значением через == даёт false.

  @Test
  void compareWrappersIntegerGivesFalse() {
    Integer a = 128;
    Integer b = 128;
    assertFalse(a == b);
  }

  @Test
  void compareWrappersShortGivesFalse() {
    Short a = 128;
    Short b = 128;
    assertFalse(a == b);
  }

  //Написать тест в котором неявный анбоксинг вызывает исключение.


  @Test
  void unboxing() {

    try {
      Character character = null;
      char c = character;
      assertNotEquals(character, c);
    } catch (NullPointerException e) {
      e.printStackTrace();

    }
  }
}