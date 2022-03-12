package net.broscorp.gc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class GarbObjTest {

  @Test
  void testForReferenceCounting() {

    for (int i = 0; i < 100; i++) {
      new GarbObj(String.valueOf(i), null);
    }

    System.gc();

  }

  @Test
  void testForTracing() {

    GarbObj link = null;

    for (int i = 0; i < 100; i++) {
      link = new GarbObj(String.valueOf(i), link);

    }

    System.gc();

    assertNotNull(link);

  }

  @Test
  void testForTracingObj() {

    GarbObj fistLink = new GarbObj(String.valueOf(1), null);
    GarbObj secondLink = new GarbObj(String.valueOf(2), null);

    System.gc();

    fistLink = secondLink;
    secondLink = null;

    System.gc();

    assertNotNull(fistLink);

  }


}