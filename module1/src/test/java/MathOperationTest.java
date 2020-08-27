import static org.junit.jupiter.api.Assertions.assertEquals;

import net.broscorp.override.overload.MathOperation;
import net.broscorp.override.overload.Multiplication;
import net.broscorp.override.overload.Sum;
import org.junit.jupiter.api.Test;

public class MathOperationTest {

  Multiplication multiplication = new Multiplication();
  Sum sum = new Sum();

  /**
   * 1. Метод, с одним аргументом примитивом, а вторым – оберткой, не будет компилироваться.
   * 2. Аннотация @Override нужна, что бы указать что мы переопределяем уже существующий метод.
   */
  @Test
  public void multiplicationDoubleTest() {
    double a = 2;
    double b = 2;
    assertEquals(4, multiplication.mathOperation(a, b));

  }

  @Test
  public void multiplicationIntTest() {
    int a = 2;
    int b = 2;
    assertEquals(4, multiplication.mathOperation(a, b));

  }

  @Test
  public void multiplicationIntegerTest() {
    Integer a = 2;
    Integer b = 2;
    assertEquals(4, multiplication.mathOperation(a, b));

  }

  @Test
  public void sumDoubleTest() {
    double a = 2;
    double b = 2;
    assertEquals(4, sum.mathOperation(a, b));

  }

  @Test
  public void sumIntTest() {
    int a = 2;
    int b = 2;
    assertEquals(4, sum.mathOperation(a, b));

  }

  @Test
  public void sumIntegerTest() {
    Integer a = 2;
    Integer b = 2;
    assertEquals(4, sum.mathOperation(a, b));

  }
}
