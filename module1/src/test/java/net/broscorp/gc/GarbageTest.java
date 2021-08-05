package net.broscorp.gc;

import org.junit.jupiter.api.Test;

public class GarbageTest {

  @Test
  void testingGC() {

    for (int i = 0; i < 200000; i++) {
      new Faculty("faculty" + i);
    }
  }

  @Test
  void saveTest() throws InterruptedException {
    GC.SAVE = new GC();

    GC.SAVE = null;
    System.out.println("clean gc");
    System.gc();
    System.out.println("sleep 5000 millis");
    Thread.sleep(5000);

    if (GC.SAVE != null) {
      System.out.println("i'm here");
    } else {
      System.out.println("loose");
    }
  }
}
