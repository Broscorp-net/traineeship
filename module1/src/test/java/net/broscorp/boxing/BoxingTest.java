package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoxingTest {

  //  переменные типа Byte, Short, Integer и Long хранятся в кэше
  //  если находятся в диапазоне от -128 до +127
  //  Character от 0 до 127
  //  присоздании новой переменной JVM проверяет кэш,
  //  для Integer диапазон можно изменить при запуске
  @DisplayName("oneWrap == twoWrap")
  @Test
  void testCompareSameWrappers() {
    Integer oneWrap = 100;
    Integer twoWrap = 100;
    assertSame(oneWrap, twoWrap);
  }

  @DisplayName("oneWrap != twoWrap, v.1")
  @Test
  void testCompareDifferentWrappersOne() {
    Integer oneWrap = 200;
    Integer twoWrap = 200;
    assertNotSame(oneWrap, twoWrap);
  }

  @DisplayName("oneWrap != twoWrap, v.2")
  @Test
  void testCompareDifferentWrappersTwo() {
    Integer oneWrap = new Integer(100);
    Integer twoWrap = new Integer(100);
    assertNotSame(oneWrap, twoWrap);
  }

  @DisplayName("Unboxing wrapper throw Exception")
  @Test
  void testUnboxingWrapperNpe() {
    Integer wrap = null;
    assertThrows(NullPointerException.class, () -> System.out.println(wrap.intValue()));
  }
}
