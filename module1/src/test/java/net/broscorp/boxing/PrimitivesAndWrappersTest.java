package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PrimitivesAndWrappersTest {

  @Test
  public void twoWrapperTypesEqualTest() {
    Integer x1 = 5;
    Integer x2 = 5;
    assertTrue(x1 == x2);
  }

  @Test
  public void twoWrapperTypesNotEqualTest() {
    Integer x1 = 128;
    Integer x2 = 128;
    assertFalse(x1 == x2);
  }

  @Test
  public void twoWrapperTypesNotEqualTest2() {
    Integer x1 = new Integer(1);
    Integer x2 = new Integer(1);
    assertFalse(x1 == x2);
  }

  @Test
  public void exceptionExpectedTest() {
    assertThrows(NullPointerException.class,
        () -> {
        Integer x1 = null;
        int x2 = x1;
        });
  }
}
