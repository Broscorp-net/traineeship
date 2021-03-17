package net.broscorp.boxing;

import static java.lang.Integer.valueOf;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class WrapperTypeTest {

  @Test
  void givenTwoEqualWrapperTypeValues_whenCompare_thenReturnTrue() {
    Integer firstValue = 56;
    Integer secondValue = 56;

    assertTrue(firstValue == secondValue);
  }

  @Test
  void givenTwoEqualWrapperTypeValues_whenCompare_thenReturnFalse() {
    Integer firstValue = valueOf(128);
    Integer secondValue = valueOf(128);

    assertFalse(firstValue == secondValue);
  }

  @Test
  void givenWrapperTypeEqualNull_whenCompareWithZero_thenNullPointerExceptionThrown() {

    assertThrows(NullPointerException.class, () -> {
      Double value = null;
      boolean result = value == 0;
    });
  }
}
