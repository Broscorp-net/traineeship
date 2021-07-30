package net.broscorp.boxing;


import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BoxingTest {
  @Test
  void testSame() {

    Integer i = 18;
    Integer i2 = 18;

    assertTrue(i == i2);
  }

  @Test
  void testDiffer() {

    Integer i = 188;
    Integer i2 = 188;

    assertFalse(i == i2);
    // in this example, the assumed value is out of the scope of the cache -> create a new object
    // every time
  }

  @Test
  void testDiffer2() {

    Integer i = new Integer(18);
    Integer i2 = new Integer(18);

    assertFalse(i == i2);

    // create a new object every time
  }

  @Test
  void testUnboxException() {
    Integer i = null;

    assertThrows(
        Exception.class,
        () -> {
          int i2 = i;
        });

    //        catch exception '_'

  }
}
