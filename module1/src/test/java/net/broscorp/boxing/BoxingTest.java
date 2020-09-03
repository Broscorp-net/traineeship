package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  public void testWrapperEqualsExpectedTrue() {
    Integer firstValue = 1000;
    Integer secondValue = firstValue;

    Integer thirdValue = 10;
    Integer fourthValue = 10;

    Assertions.assertTrue(firstValue == secondValue);
    Assertions.assertTrue(thirdValue == fourthValue);
  }

  @Test
  public void testWrapperEqualsExpectedFalse() {
    Integer firstValue = 1000;
    Integer secondValue = 1000;

    Assertions.assertFalse(firstValue == secondValue);
  }

  @Test
  public void testExplicitBoxingUnboxingExpetedTrue() {
    int firstValue = 1000;
    Integer secondValue = 1000;

    Assertions.assertTrue(firstValue == secondValue.intValue());
    Assertions.assertTrue(secondValue.equals(Integer.valueOf(firstValue)));
  }

  @Test
  public void testImplicitBoxingUnboxingExpetedTrue() {
    int firstValue = 1000;
    Integer secondValue = 1000;

    Assertions.assertTrue(firstValue == secondValue);
    Assertions.assertTrue(secondValue.equals(firstValue));
  }
}
