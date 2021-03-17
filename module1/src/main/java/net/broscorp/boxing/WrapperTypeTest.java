package net.broscorp.boxing;

import static java.lang.Integer.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Aleksandr Nesterov
 */
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

    Assertions.assertThrows(NullPointerException.class, () -> {
      Double value = null;
      boolean result = value == 0;
    });
  }
}
