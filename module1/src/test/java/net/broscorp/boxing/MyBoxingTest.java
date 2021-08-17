package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MyBoxingTest {

  @Test
  void boxing1Test() {

    Integer c = 127;//java.lang.Integer.valueOf(int)
    Integer d = 127;//java.lang.Integer.valueOf(int)

    assertTrue(c == d);
  }

  @Test
  void boxing2Test() {
    Integer a = 128;
    Integer b = 128;

    assertFalse(a == b);//class IntegerCache - max int = 127

    Integer z = new Integer(5);
    Integer x = new Integer(5);

    assertFalse(x == z);//different references, because creating with 'new'
  }

  @Test
  void boxing3Test() {

    assertThrows(NullPointerException.class, () -> {
      Integer a = null;
      int c = a;
    });
  }

}


