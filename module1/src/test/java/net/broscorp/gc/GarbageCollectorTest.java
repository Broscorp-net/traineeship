package net.broscorp.gc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GarbageCollectorTest {

  @Test
  void objectsTest() {
    for (int i = 1;i < 10000;i++) {
      GarbageCollectorObject gco = new GarbageCollectorObject(i);
      GarbageCollectorObject tmp = gco;
      gco = null;
      tmp = null;
    }
  }
}