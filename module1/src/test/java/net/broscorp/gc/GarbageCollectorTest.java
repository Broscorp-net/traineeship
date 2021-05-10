package net.broscorp.gc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GarbageCollectorTest {

  @Test
  void objectsTest() {
    for (int i = 1; i < 7000; i++) {
      GarbageCollectorObject gco = new GarbageCollectorObject(i);
      GarbageCollectorObject tmp = gco;
      gco = null;
      tmp = null;
    }
  }

  @Test
  void objectsTestTwo() {
    for(int i = 1;i < 30000;i++) {
      GarbageCollectorObject obj1 = new GarbageCollectorObject("obj1");
      GarbageCollectorObject obj2 = new GarbageCollectorObject("obj2");
      obj1 = obj2;
      obj2 = obj1;
    }
  }

}