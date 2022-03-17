package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  void trueEqualTest() {
    int c = 500;
    Integer a = c;
    Integer b = c;
    Assertions.assertFalse(a == b);
    /*Нашел в документации "Этот метод всегда будет кэшировать значения в диапазоне от -128 до 127",
     т.е. в этих пределах true, а далее false. Я так понимаю за пределом кеширования создается
     новые объекты. А так как мы == сравниваем ссылки, то они будут разные.
     */
  }


  @Test
  void falseEqualTest() {
    Integer a = new Integer(43);
    Integer b = Integer.valueOf(43);
    Assertions.assertFalse(a == b);
  }

  @Test
  void secondFalseEqualTest() {
    Integer a = new Integer(43);
    Integer b = 43;
    Assertions.assertFalse(a == b);
  }



  @Test
  void unBoxingTest() {
    Integer a = null;
    NullPointerException e = Assertions.assertThrows(NullPointerException.class,() -> {
      int b = a;
    });
  }

}