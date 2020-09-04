package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BoxingUnboxingTest {

  /**
   * Идея теста в том, чтобы создать две примитивных переменных,
   * после чего оборачиваем их в Integer. И сравниваем уже непосредственно
   * два объекта. Уже зная, что мы не выделяем для них разные ссылки, мы
   * просто сравним два одинаковых объекта, в которых хранятся одинаковые данные.
   * Ожидаем True.
   */
  @Test
  public void boxingTest() {
    int firstNumber = 1;
    int secondNumber = 1;
    Integer firstInteger = firstNumber;
    Integer secondInteger = secondNumber;
    assertTrue(firstInteger == secondInteger);
  }

  /**
   * В этом тесте, вы записываем два объекта Integer, используя downcast.
   * Таким образом, мы получаем примитивны тип данных int. Ожидаем True.
   */
  @Test
  public void unboxingTest() {
    Integer firstNumber = 5;
    Integer secondNumber = 5;

    int resultOfConcat = firstNumber + secondNumber;
    assertEquals(10, resultOfConcat);
  }

}
