package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  public void comparingWrappersWithEqualValuesShouldReturnTrue() {
    Integer int1 = new Integer(5);
    Integer int2 = int1;

    Assertions.assertTrue(int1 == int2);
  }

  @Test
  public void comparingWrappersWithEqualValuesShouldReturnFalse() {
    Integer int1 = new Integer(5);
    Integer int2 = new Integer(5);

    Assertions.assertFalse(int1 == int2);
  }

  @Test
  public void comparingWrappersWithEqualValuesShouldReturnFalse2() {
    Integer int1 = new Integer(5);
    Integer int2 = new Integer(2 + 3);

    Assertions.assertFalse(int1 == int2);
  }

  @Test
  public void autounboxingShouldThrowNullPointerExceptionWhenIntegerEqualsNull() {
    Integer int1 = null;
    int int2 = 0;
    Assertions.assertThrows(NullPointerException.class, () -> {
      int sum = int1 + int2;
    });
  }
}
