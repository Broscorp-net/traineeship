package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoxingTest {
  @Test
  public void wrappersEquityMustBeTrue() {
    Float someFloat = 5.0f;
    Double someDouble = 5.0;
    Assertions.assertTrue(someDouble == (float) someFloat);
    // Assertions.assertTrue((Long) 10 == (Integer) 10);
  }

  @Test
  public void wrappersEquityMustBeFalse() {
    Integer someInteger = 5;
    Long someLong = 5L;
    Assertions.assertFalse(someInteger == (Number) someLong);
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
