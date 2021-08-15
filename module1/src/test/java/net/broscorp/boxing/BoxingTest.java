package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  void equalIntegerTest() {
    Integer a = 1;
    Integer b = 1;
    assertTrue(a == b);
  }

  @Test
  void notEqualIntegerTest() {
    Integer a = new Integer(1);
    Integer b = new Integer(1);
    assertFalse(a == b);
  }

  @Test
  void notEqualIntegerTestTwo() {
    String str = "1";
    Integer a = Integer.parseInt(str);
    Integer b = new Integer(Integer.parseInt(str));
    assertFalse(a == b);
  }

  @Test
  void unboxingExceptionTest() {
    Integer integer = null;
    assertThrows(NullPointerException.class, () ->  {
      int value = integer + 1;
    });
  }
}
