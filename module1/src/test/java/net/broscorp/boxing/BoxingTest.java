package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {
  @Test
  public void checkEqualWrappersTypes() {
    Integer a = new Integer(1);
    Integer b = a;
    Assertions.assertTrue(a == b);
}
  @Test
  public void checkNotEqualWrappersTypes() {
    Integer a = new Integer(1);
    Integer b = new Integer(1);
    Assertions.assertFalse(a == b);
  }
  @Test
  public void checkUnboxingError() {
    try {
      Integer a = null;
      Double b = Double.valueOf(a);
    } catch (NullPointerException e) {
        Assertions.assertTrue(true);
    }
  }

}
