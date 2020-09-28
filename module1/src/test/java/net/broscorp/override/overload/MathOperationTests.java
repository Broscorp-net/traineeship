package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathOperationTests {

  @Test
  public void mathOperationsWithTwoDoubles() {
    MathOperation mathAdding = new MathAdding();
    MathOperation mathMultiplying = new MathMultiplying();
    double first = 7.00;
    double second = 8.00;
    assertEquals(15.00, mathAdding.operation(first, second));
    assertEquals(56.00, mathMultiplying.operation(first, second));
  }

  @Test
  public void mathOperationsWithTwoDoubleWrappers() {
    MathOperation mathAdding = new MathAdding();
    MathOperation mathMultiplying = new MathMultiplying();
    Double first = 7.00;
    Double second = 8.00;
    assertEquals(15.00, mathAdding.operation(first, second));
    assertEquals(56.00, mathMultiplying.operation(first, second));
  }

  @Test
  public void mathOperationsWithTwoIntegers() {
    MathOperation mathAdding = new MathAdding();
    MathOperation mathMultiplying = new MathMultiplying();
    int first = 7;
    int second = 8;
    assertEquals(15.00, mathAdding.operation(first, second));
    assertEquals(56.00, mathMultiplying.operation(first, second));
  }

  @Test
  public void mathOperationsWithTwoIntegerWrappers() {
    MathOperation mathAdding = new MathAdding();
    MathOperation mathMultiplying = new MathMultiplying();
    Integer first = 7;
    Integer second = 8;
    assertEquals(15.00, mathAdding.operation(first, second));
    assertEquals(56.00, mathMultiplying.operation(first, second));
  }
  /*
  При вызове метода с двумя разными аргументами (примитив и класс-обертка) происходит ошибка,
  так как две перегрузки подходят и джава не может определить, какую использовать.

  @Test
  public void mathOperationsWithTwoDifferentArguments() {
    MathOperation mathAdding = new MathAdding();
    MathOperation mathMultiplying = new MathMultiplying();
    double first = 7.00;
    Double second = 8.00;
    assertEquals(15.00, mathAdding.operation(first, second));
    assertEquals(56.00, mathMultiplying.operation(first, second));
  }
  */
}
