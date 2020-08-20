import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class primitivesTest {

  @Test
  public void intMaxValueSUm() {
    int a = Integer.MAX_VALUE;
    int b = Integer.MAX_VALUE;

    assertTrue(a + b < 0);
  }

  @Test
  public void longToInt() {
    long a = Long.MAX_VALUE;
    int b = (int) a;

    assertNotEquals(a, b);
  }

  @Test
  public void floatToDouble() {
    float a = 10.60f;
    double b = a;

    assertNotEquals(10.60, b);
  }

  @Test
  public void operationWithFloatingPoint() {
    double a = 2.0 - 1.1;

    assertNotEquals(0.9, a);
  }

}
