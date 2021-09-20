package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoxingTest {

  @Test
  void throwNullPointerException() {
    Assertions.assertThrows(NullPointerException.class, () -> {
      Integer i = null;
      int j = i.intValue();
      System.out.println(j);
    });
  }

  @Test
  void returnTrue() {
    assertTrue(Boxing.returnTrue(5, "5"));
  }

  @Test
  void returnFalseFirstVar() {
    assertFalse(Boxing.returnFalseOne(5));
  }

  @Test
  void returnFalseSecondVar() throws Exception {
    assertFalse(Boxing.returnFalseTwo(129));
  }
}