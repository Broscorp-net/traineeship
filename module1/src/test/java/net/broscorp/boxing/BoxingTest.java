package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

public class BoxingTest {

  /**
   * When comparing with ==, only links are compared.
   * Memory is allocated for each object, when objects are created with "new"
   * Expecting False
   */
  @Test
  public void comparingNewObjects() {
    Integer firstInt = new Integer(7);
    Integer secondInt = new Integer(7);
    assertFalse(firstInt == secondInt);
  }

  /**
   * When comparing with ==, only links are compared.
   * In this case, two identical objects with the same content are compared
   * Expecting True
   */
  @Test
  public void comparingObjectsFromMemory() {
    Integer firstDouble = 7;
    Integer secondDouble = 7;
    assertTrue(firstDouble == secondDouble);
  }

  /**
   * Using downcast here from long to int
   * Expecting True
   */
  @Test
  public void explicitTypeConversion() {
    long b = 15;
    int a = (int) b;
    assertTrue(a == b);
  }

  /**
   * Upcasting here from int to long
   * Expecting True
   */
  @Test
  public void implicitTypeConversion() {
    int usualInt = 345;
    long usualLong = usualInt;
    assertTrue(usualInt == usualLong);
  }

}
