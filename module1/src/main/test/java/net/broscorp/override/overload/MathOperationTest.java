package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathOperationTest {

  MultiRealization multiRealization = new MultiRealization();
  SumRealization sumRealization = new SumRealization();

  /**
   * Эту аннотацию @Override Мы должны дать Java понять, что мы не ошиблись и не назвали метод
   * названием, которое уже есть, из-за невнимательности. Чтобы сказать, что мы знаем, что делаем и
   * действительно хотим переопределить метод, нужно указать @Override явно.
   * Таким образом, если вы совершите распространённую ошибку, например: - Опечатка в имени метода -
   * Не правильно задаёте параметры То вы будете предупреждены об этом. Так же улучшает читаемость
   * кода.
   */
  @Test
  public void multiDoubleMethodDoubleTest() {
    double first = 7;
    double second = 7;
    assertEquals(49, multiRealization.doubleMethod(first, second));
  }

  @Test
  public void multiDoubleMethodIntTest() {
    int first = 7;
    int second = 7;
    assertEquals(49, multiRealization.doubleMethod(first, second));
  }

  @Test
  public void multiDoubleMethodIntegerTest() {
    Integer first = 7;
    Integer second = 7;
    assertEquals(49, multiRealization.doubleMethod(first, second));
  }

  @Test
  public void sumDoubleMethodDoubleTest() {
    double first = 7;
    double second = 7;
    assertEquals(14, sumRealization.doubleMethod(first, second));
  }

  @Test
  public void sumDoubleMethodIntTest() {
    int first = 7;
    int second = 7;
    assertEquals(14, sumRealization.doubleMethod(first, second));
  }

  @Test
  public void sumDoubleMethodIntegerTest() {
    Integer first = 7;
    Integer second = 7;
    assertEquals(14, sumRealization.doubleMethod(first, second));
  }
}
