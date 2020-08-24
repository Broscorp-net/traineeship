package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class TestWrapperType {

  @Test
  public void equalsBetweenWrapperType() {
    Integer firstValue = new Integer(8);
    Integer secondValue = new Integer(8);
    assertFalse(firstValue == secondValue);
  }

  @Test
  public void equalsBetweenWrapperTypeBoxing() {
    Integer firstValue = 8;
    Integer secondValue = 8;
    assertTrue(firstValue == secondValue);
  }

  @Test
  public void equalsBetweenWrapperTypeUnboxing() {
    Integer firstValue = new Integer(8);
    Integer secondValue = new Integer(8);
    int firstUnboxingValue = firstValue;
    int secondUnboxingValue = secondValue;
    assertTrue(firstUnboxingValue == secondUnboxingValue);
  }

}
