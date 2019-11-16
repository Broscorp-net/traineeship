package net.broscorp.e_primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class E_primitivesTest {
  /**
   * In this taste case I try increment max Byte value, and failed on test execution. Reason - byte
   * can consist only 127;
   */
  @Test
  void testOverflow() {

    byte a = Byte.MAX_VALUE;
    a++;
    byte result = a;
    assertEquals(128, result);
  }
  
 /**
  * Convert for Long to Integer 
  */
  @Test
  void convertLongToInt() {
    long x = (long)Integer.MAX_VALUE;
    x++;
    int y = (int) x;
    assertEquals(x,y);
}


  /**
   * In this test case I try to push double, into integer. Integer has now decimal part, that means
   * loosing of information. And as a result - test had failed.
   */
  @Test
  void testConvertation() {

    double a = 12.9999;
    int b = (int) a;
    assertEquals(a, b);

  }


  /**
   * This test depictured mess conduction during Java simple arithmetical function (multiplication)
   * upon numbers with decimal point. We know for sure that 2.11*5 = 10.55. This is happens because
   * of storing data with decimal point will take a lot of memory, as we knows memory allocated for
   * primitives is restricted. So the only way to store kinda data that makes rounding. But as well
   * as all data finally stored in bite format, we have lose on precision. This is common compute
   * problem, not just Java. By the way Java has several solution for this problem: 1) key word
   * "strictfp" - which is guaranty that all way long during calculation data will be store with
   * restrict precision on rounding 2) BigDecimal Class - which handles grate precision by providing
   * very big and very small floating points numbers
   * 
   * 
   * Result on test - loosing of data, and fail on test.
   */
  @Test
  void testDeviation() {

    double a = 2.11;
    double b = 5.0;
    double result = a * b;
    assertEquals(10.55, result);
  }
}

