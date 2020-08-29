package net.broscorp.override.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumMathOperationTest {

  private final MathOperation adder = new SumMathOperation();

  @Test
  public void testCalculatePrimitiveDouble() {
    double x = 4.0;
    double y = 2.0;

    double actualResult = adder.calculate(x, y);

    Assertions.assertEquals(6.0, actualResult);
  }

  @Test
  public void testCalculatePrimitiveInt() {
    int x = 4;
    int y = 2;

    double actualResult = adder.calculate(x, y);

    Assertions.assertEquals(6.0, actualResult);
  }

  @Test
  public void testCalculateBoxedDouble() {
    Double x = 4.0;
    Double y = 2.0;

    double actualResult = adder.calculate(x, y);

    Assertions.assertEquals(6.0, actualResult);
  }

  @Test
  public void testCalculateBoxedInt() {
    Integer x = 4;
    Integer y = 2;

    double actualResult = adder.calculate(x, y);

    Assertions.assertEquals(6.0, actualResult);
  }
}
