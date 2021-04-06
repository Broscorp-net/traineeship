package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  public void ComparingWrappersWithEqualValuesShouldReturnTrue() {
    Integer int1 = new Integer(5);
    Integer int2 = int1;

    Assertions.assertTrue(int1 == int2);
  }

  @Test
  public void ComparingWrappersWithEqualValuesShouldReturnFalse() {
    Integer int1 = new Integer(5);
    Integer int2 = new Integer(5);

    Assertions.assertFalse(int1 == int2);
  }

  @Test
  public void AutounboxingShouldThrowNullPointerExceptionWhenIntegerEqualsNull() {
    Integer int1 = null;
    int int2 = 0;
    Assertions.assertThrows(NullPointerException.class, () -> {
      int sum = int1 + int2;
    });
  }
}
