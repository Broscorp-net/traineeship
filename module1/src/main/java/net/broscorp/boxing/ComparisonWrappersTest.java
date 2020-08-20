package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ComparisonWrappersTest {

  Integer firstNumber = 7;
  Integer secondNumber = 7;

  @Test
  public void comparisonTest() {
    assertFalse(firstNumber == secondNumber);
  }

  @Test
  public void equalsTest() {
    assertTrue(firstNumber.equals(secondNumber));
  }

}
