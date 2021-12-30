package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  void wrappersComparisonTrue() {
    Integer i1 = 5;
    Integer i2 = 5;
    Assertions.assertTrue(i1 == i2);
  }

  @Test
  void wrappersComparisonFalse() {
    // https://stackoverflow.com/questions/10149959/using-operator-in-java-to-compare-wrapper-objects
    Integer i1 = 1000;
    Integer i2 = 1000;
    Assertions.assertFalse(i1 == i2);
  }

  @Test
  void implicitUnboxingException() {
    // Not certain this scenario was the intention, please advise
    Integer i = null;
    Assertions.assertThrows(Exception.class, () -> {
      double d = i;
    });
  }
}
