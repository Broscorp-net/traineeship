package net.broscorp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyTest {

  @Test
  void testNumericOverflow() {
    byte b = 120;
    b += 19;
    Assertions.assertTrue(b<0);
  }

  @Test
  void testTypes() {
    long a = 4;
    int b = (int) a;
    Assertions.assertEquals(a,b);
    long a2 = -214748364812L;
    int b2 = (int) a2;
    Assertions.assertNotEquals(a2,b2," Problem : numeric type overflow");

    float c = 5f;
    double d = c;
    Assertions.assertEquals(c,d);
    float c2 = 34.456f;
    double d2 = c2;
    Assertions.assertEquals(c2,d2," If one of the operands of the operation is of the double type,"
            + " then the second operand is also converted to the double type");
  }

  @Test
  void testFallibility() {
    int a = 2147483647;
    float b = a;
    Assertions.assertEquals(a,b);
    double c = 2.0 - 1.1;
    Assertions.assertTrue(c != 0.9);
  }


}