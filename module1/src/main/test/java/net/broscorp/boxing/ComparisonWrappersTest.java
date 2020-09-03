package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ComparisonWrappersTest {

  @Test
  public void comparisonWithNewObjectsTest() {
    Integer firstNumber = new Integer(7);
    Integer secondNumber = new Integer(7);
    assertFalse(firstNumber == secondNumber);
  }

  @Test
  public void comparisonObjectsTest() {
    Integer firstNumber = 7;
    Integer secondNumber = 7;
    assertTrue(firstNumber == secondNumber);
  }

}
