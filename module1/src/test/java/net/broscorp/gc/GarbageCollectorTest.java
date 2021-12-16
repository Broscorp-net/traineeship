package net.broscorp.gc;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GarbageCollectorTest {

  @Test
  void createLotsOfObjects() {

    for(int id = 0; id < 100_000; id++) {
      Asteroid asteroid = new Asteroid(String.valueOf(id));
    }
    System.gc();
  }

}
