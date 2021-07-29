package net.broscorp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WrappersAndBoxingTest {

  //1.Написать тест, в котором сравнение двух оберточных типов с одинаковым значением
  // через __==__ даёт true.

  @Test
  public void comparisonOfTwoCharactersWithTheSameValueTrueTest() {
    Character characterFirst = 'A';
    Character characterSecond = 'A';
    Assertions.assertTrue(characterFirst == characterSecond);
  }

  //2.Написать тест, в котором сравнение двух оберточных типов с одинаковым значением
  // через __==__ даёт false.
  // (дополнительная похвала если придумать два таких варианта)

  @Test
  public void comparisonOfTwoCharactersWithTheSameValueFalseTest() {
    Character characterFirst = new Character('A');
    Character characterSecond = new Character('A');
    Assertions.assertFalse(characterFirst == characterSecond);
  }

  /**
   * Cache to support the object identity semantics of autoboxing for values between 0 and 127.
   */
  @Test
  public void comparisonOfTwoCharactersWithTheSameValueFalseTestNew() {
    Character characterFirst = Character.valueOf('Я');
    Character characterSecond = Character.valueOf('Я');
    Assertions.assertFalse(characterFirst == characterSecond);
  }


  /**
   * Cache to support the object identity semantics of autoboxing for values between -128 and 127
   * (inclusive) as required by JLS.
   */
  @Test
  public void comparisonOfTwoIntegersWithTheSameValueFalseTest() {
    Integer firstInt = 300;
    Integer secondInt = firstInt;
    secondInt = 300;
    Assertions.assertFalse(firstInt == secondInt);
  }

  //3.Написать тест в котором неявный анбоксинг вызывает исключение.

  @Test
  public void implicitUnboxingThrowsAnExceptionTest() {
    Character character = null;
    Assertions.assertThrows(NullPointerException.class, () -> {
      char ch = character;
    });
  }

}
