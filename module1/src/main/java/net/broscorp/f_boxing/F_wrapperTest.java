package net.broscorp.f_boxing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class F_wrapperTest {

  /**
   * In this test I compare two Integer Objects, which are allocated in different heap area places.
   * 
   */
  @Test
  void testEquality() {
    Integer a = 500;
    Integer b = 500;
    assertTrue(a != b);
  }

  /**
   * In this test case I established same comparison as in test above, but this time I got true as
   * test result. This is happens because of Integer Pool that Java used do not create new Object.
   * Pool has precise limits [-128; 127];
   */
  @Test
  void testEqualityIntegerPoolRestriction() {
    Integer a = 127;
    Integer b = 127;
    assertTrue(a == b);
  }

  /**
   * In this test case I deliberately wrapping primitive into wrapper Integer Class, and assure that
   * eventually I got an instance of Class.
   */
  @Test
  void testAutoboxing() {
    int b = 0;
    assertTrue(Integer.valueOf(b) instanceof Integer);
  }

  /**
   * In this test case I deliberately unpack instances out of Class, and assure equality between
   * references which are pointed on one object.
   */
  @Test
  void testAutounboxing() {
    Integer c = 500;
    Integer b = 500;
    assertTrue(c.intValue() == b.intValue());
  }

}
