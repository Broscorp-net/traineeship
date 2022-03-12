package net.broscorp.gc;

import org.junit.jupiter.api.Test;

public class gcTest {

  FirstExample garbageCollector;

  @Test
  void objectCreator() {
    for (int i = 0; i < 100000000; i++) {
      garbageCollector = new FirstExample(new SecondExample());
      garbageCollector = null;

      garbageCollector = new FirstExample(new SecondExample());
      System.out.println(garbageCollector);
    }
  }
}
