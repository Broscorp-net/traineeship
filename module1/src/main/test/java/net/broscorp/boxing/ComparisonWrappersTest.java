package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ComparisonWrappersTest {

  /**
   * В этом тесте мы создаём два новых объекта, отдельно для каждого выделяем память
   * и создавая новую ссылку. При сравнивании через ==, мы сравниваем не содержание объекта,
   * а его ссылки, так как мы создаём две новых ссылки, то и возвращать должно False.
   */
  @Test
  public void comparisonWithNewObjectsTest() {
    Integer firstNumber = new Integer(7);
    Integer secondNumber = new Integer(7);
    assertFalse(firstNumber == secondNumber);
  }

  /**
   * Как и в случае с прошлым тестом мы сравниваем два объекта, только в этот раз
   * мы не выделяем память отдельно, и не создаём новых ссылок, в этом случае мы сравниваем
   * два одинаковых объекта с одинаковым наполнением, ожидаем True
   */
  @Test
  public void comparisonObjectsTest() {
    Integer firstNumber = 7;
    Integer secondNumber = 7;
    assertTrue(firstNumber == secondNumber);
  }

}
