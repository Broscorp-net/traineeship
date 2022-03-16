package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  void trueEqualTest() {
    int c = 500;
    Integer a = c;
    Integer b = c;
    Assertions.assertTrue(a == b);
  }

  @Test
  void falseEqualTest() {
    Integer a = new Integer(43);
    Integer b = Integer.valueOf(43);
    Assertions.assertFalse(a == b);
  }

  @Test
  void secondFalseEqualTest() {
    Integer a = new Integer(43);
    Integer b = 43;
    Assertions.assertFalse(a == b);
  }



  @Test
  void unBoxingTest() {
    Integer a = null;
    NullPointerException e = Assertions.assertThrows(NullPointerException.class,() -> {
      int b = a;
    });
  }

}