package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoxingTest {

  Boxing boxing;

  @BeforeEach
  void setUp() {
    boxing = new Boxing(5);
  }

  @Test
  public void equalsBoxingTrue() {
    assertTrue(boxing.getNumberOne() == boxing.getNumberTwo());
  }

  @Test
  public void equalsBoxingFalseOne() {
    assertFalse(boxing.getNumberThree() == boxing.getNumberFour());
  }

  @Test
  public void equalsBoxingFalseTwo() {
    assertFalse(boxing.getNumberTwo() == boxing.getNumberThree());
  }

  @Test
  public void unboxingException() {
    boolean wosException = false;
    try {
      int i = boxing.getNulls();
    } catch (Exception e) {
      wosException = true;
    }
    assertTrue(wosException);

  }

}