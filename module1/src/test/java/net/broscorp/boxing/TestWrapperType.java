package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestWrapperType {

  @Test
  public void equalsBetweenTwoWrapperTypeGivesTrue() {
    Integer firstValue = 8;
    Integer secondValue = 8;
    assertTrue(firstValue == secondValue);
  }

  @Test
  public void equalsBetweenTwoWrapperTypeGivesFalse() {
    Integer firstValue = Integer.valueOf(8);
    Integer secondValue = Integer.valueOf(8);
    assertFalse(firstValue == secondValue);
  }

  @Test
  public void equalsBetweenWrapperTypeUnboxing() {
    Integer firstValue = Integer.valueOf(8);
    Integer secondValue = Integer.valueOf(8);
    int firstUnboxingValue = firstValue;
    int secondUnboxingValue = secondValue;
    assertTrue(firstUnboxingValue == secondUnboxingValue);
  }

  @Test
  public void equalsBetweenWrapperTypeBoxing() {
    int firstValue = 8;
    int secondValue = 8;
    Integer firstBoxingValue = firstValue;
    Integer secondBoxingValue = secondValue;
    assertTrue(firstBoxingValue == secondBoxingValue);
  }

}
