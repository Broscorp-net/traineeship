package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  void falseTest() {
    Integer a = 128;
    Integer b = 128;
    Assertions.assertEquals(false, a == b);
  }

  @Test
  void secondFalseTest()  {
    Double a = 1.0;
    Double b = 1.0;
    Assertions.assertEquals(false, a == b);
  }

  @Test
  void trueTest() {
    Integer a = 10;
    Integer b = 10;
    Assertions.assertEquals(true, a == b);
  }

  @Test
  void exceptionTest()  {
    Integer a = null;
    try {
      a++;
    } catch (NullPointerException e) {
      Assertions.assertNull(a);
    }
  }
}
