package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WrappersTest {

  @Test
  void compareEqualValueSameReferenceWrappers() {
    Integer i1 = new Integer(5);
    Integer i2 = i1;
    Boolean b1 = new Boolean(false);
    Boolean b2 = b1;
    // https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html#jls-5.1.7
    Integer i3 = 127;
    Integer i4 = 127;
    final Boolean b3 = false;
    final Boolean b4 = false;

    assertTrue(i1 == i2);
    assertTrue(i3 == i4);
    assertTrue(b1 == b2);
    assertTrue(b3 == b4);
  }

  @Test
  void compareEqualValueDifferentReferenceWrappers() {
    Integer i1 = new Integer(5);
    Integer i2 = new Integer(5);
    Boolean b1 = new Boolean(false);
    Boolean b2 = new Boolean(false);
    // https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html#jls-5.1.7
    Integer i3 = 128;
    Integer i4 = 128;

    assertFalse(i1 == i2);
    assertFalse(i3 == i4);
    assertFalse(b1 == b2);
  }

  @Test
  void implicitlyBoxUnbox() {
    Integer intWrapper = 1000;
    int i = 1000;

    assertTrue(intWrapper == i);
  }

  @Test
  void explicitlyBoxUnbox() {
    Integer intWrapper = new Integer(1000);
    int i = 1000;

    assertTrue(intWrapper.intValue() == i);
    assertTrue((int)intWrapper == i);
    assertFalse(intWrapper == (Integer)i);
    assertFalse(intWrapper == Integer.valueOf(i));
  }

}
