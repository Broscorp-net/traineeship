package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoxingTest {
  @Test
  public void wrappersEquityMustBeTrue() {
    Integer someIntegerOne = 5;
    Integer someIntegerTwo = 5;

    Assertions.assertTrue(someIntegerOne == someIntegerTwo);
  }

  @Test
  public void wrappersEquityMustBeFalse() {
    Double someDoubleOne = 5.0;
    Double someDoubleTwo = 5.0;

    Assertions.assertFalse(someDoubleOne == someDoubleTwo);
  }

  @Test
  public void autoUnboxingException() {
    Assertions.assertThrows(
        NullPointerException.class,
        () -> {
          Integer someInt = null;
          int max = someInt;
        });
  }
}
