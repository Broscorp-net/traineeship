package net.broscorp.gc;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class SecondTest {

  private static ArrayList<GarbageCollectors> garbageCollectors;

  public class GarbageCollectors {

    //    @Override
    //    protected void finalize() throws Throwable {
    //      garbageCollectors.add(this);
    //      System.out.println("Method 'finalize' was used");
    //      super.finalize();
    //    }
  }

  @Test
  public void garbageCollectorsTest() {
    for (int i = 0; i < 100_000; i++) {
      GarbageCollectors garbageCollectors = new GarbageCollectors();
    }
    System.gc();
  }
}
