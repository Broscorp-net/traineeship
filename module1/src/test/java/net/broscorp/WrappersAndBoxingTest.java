package net.broscorp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WrappersAndBoxingTest {

  @Test
  void test() {
    Integer a1 = 1;
    Integer a2 = 1;
    Assertions.assertEquals(a1,a2);
    //true
    Integer b1 = 128;
    Integer b2 = 128;
    Assertions.assertEquals(b1,b2);
    //false
    Integer i = null;
    Assertions.assertNull(i);
    //NullPointerException
  }
}
