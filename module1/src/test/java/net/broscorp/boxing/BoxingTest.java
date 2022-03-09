package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  void trueEqualTest() {
    Integer a = new Integer(43);
    Integer b = Integer.valueOf(43);
    Assertions.assertEquals(a,b);
  }

  @Test
  void falseEqualTest() {
    Integer a = new Integer(43);
    Integer b = Integer.valueOf(43);
    Assertions.assertFalse(a == b);
  }

  @Test
  void secondFalseEqualTest() {
    int c = 43;
    Object a = new Integer(c);
    Object b = new Long(c);
    Assertions.assertFalse(a.equals(b));
  }

  @Test
  void unBoxingTest() {
    Integer a = null;
    NullPointerException e = Assertions.assertThrows(NullPointerException.class,() -> {
      int b = a;
    });
  }
}
