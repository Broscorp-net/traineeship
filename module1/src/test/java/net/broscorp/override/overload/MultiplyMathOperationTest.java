package net.broscorp.override.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MultiplyMathOperationTest {

  private final MathOperation multiplicator = new MultiplyMathOperation();

  @Test
  public void testCalculatePrimitiveDouble() {
    double x = 4.0;
    double y = 2.0;

    double actualResult = multiplicator.calculate(x, y);

    Assertions.assertEquals(8.0, actualResult);
  }

  @Test
  public void testCalculatePrimitiveInt() {
    int x = 4;
    int y = 2;

    double actualResult = multiplicator.calculate(x, y);

    Assertions.assertEquals(8.0, actualResult);
  }

  @Test
  public void testCalculateBoxedDouble() {
    Double x = 4.0;
    Double y = 2.0;

    double actualResult = multiplicator.calculate(x, y);

    Assertions.assertEquals(8.0, actualResult);
  }

  @Test
  public void testCalculateBoxedInt() {
    Integer x = 4;
    Integer y = 2;

    double actualResult = multiplicator.calculate(x, y);

    Assertions.assertEquals(8.0, actualResult);
  }

}
