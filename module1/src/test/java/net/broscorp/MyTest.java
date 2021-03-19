package net.broscorp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyTest {

  @Test
  void testNumericOverflow() {
    Assertions.assertTrue(true);
    byte b = 120;
    b += 19;
    System.out.println(b);
  }

  @Test
  void testTypes(){
    long a = 4;
    int b = (int) a;
    System.out.println(b);
    System.out.println("[" + Long.MIN_VALUE +" , " +  Long.MAX_VALUE + "]");
    System.out.println("[" + Integer.MIN_VALUE +" , " +  Integer.MAX_VALUE + "]");
    long a2 = -214748364812L;
    int b2 = (int) a2;
    System.out.println(b2+ " Problem : numeric type overflow");

    float c =5f;
    double d = c;
    System.out.println(d);
    System.out.println("[" + Float.MIN_VALUE +" , " +  Float.MAX_VALUE + "]");
    System.out.println("[" + Double.MIN_VALUE +" , " +  Double.MAX_VALUE + "]");
    float c2 = 34.456f;
    double d2 = c2;
    System.out.println(d2+ " If one of the operands of the operation is of the double type," +
            " then the second operand is also converted to the double type");
  }

  @Test
  void testFallibility(){
    int a = 2147483647;
    float b = a;
    System.out.println(b);
    double c = 2.0 - 1.1;
    System.out.println(c+ " Although the expected result is 0.9");
  }


}