package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  public void
      whenCompareTwoIntegersWithEqualValues_ThenTrueBecauseOfRefsToSameCachedWrapperObject() {
    Integer int1 = 99;
    Integer int2 = 99;
    Assertions.assertTrue(int1 == int2);
    Assertions.assertSame(int2, int1);
  }

  @Test
  public void
      whenCompareTwoIntegersWithEqualValues_ThenFalseBecauseOfRefsToDifferentWrapperObjects() {
    Integer int1 = 128;
    Integer int2 = 128;
    Assertions.assertFalse(int1 == int2);
    Assertions.assertNotSame(int2, int1);
  }

  @Test
  public void whenIntegerEqualsNull_ThenAutounboxingThrowsNullPointerException() {
    Integer int1 = null;
    int int2 = 1;
    Assertions.assertThrows(
        NullPointerException.class,
        () -> {
          int sum = int1 + int2;
        });
  }
}
