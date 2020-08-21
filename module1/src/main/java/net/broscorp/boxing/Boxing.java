package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Boxing {

  Integer firsNumber = 127;
  Integer secondNumber = 127;
  Integer thirdNumber = 128;
  Integer fourthNumber = 128;

  @Test
  public void compareTestInCache() {
    assertTrue(firsNumber == secondNumber);
  }

  @Test
  public void compareTestNotInCache() {
    assertFalse(thirdNumber == fourthNumber);
  }

  @Test
  public void equalsTest() {
    assertTrue(firsNumber.equals(secondNumber));
  }

  @Test
  public void boxingTest() {
    Integer a = new Integer(10);
    int b = Integer.valueOf(10);
    assertTrue(a.equals(b));
  }

  @Test
  public void unboxingTest() {
    assertEquals(127, firsNumber);
  }
}
