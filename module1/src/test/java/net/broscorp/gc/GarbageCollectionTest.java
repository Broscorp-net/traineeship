package net.broscorp.gc;

import org.junit.jupiter.api.Test;

public class GarbageCollectionTest {

  @Test
  public void checkGarbageCollection() {
    int i = 0;
    while (true) {
      GarbageColl garbageColl = new GarbageColl();
      garbageColl.setGarbageColl(garbageColl);
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
      }
      if (i++ % 100 == 0) {
        System.out.println("Total: " + Runtime.getRuntime().totalMemory() +
            "; free: " + Runtime.getRuntime().freeMemory());
      }
    }
  }
}
