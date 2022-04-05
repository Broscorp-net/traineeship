package gc;

import net.broscorp.gc.GarbageCollector;
import org.junit.jupiter.api.Test;


public class GarbageCollectorTest {

  @Test
  public void creationBigAmountOfObjects() {
    for (int i = 0; i < 100000; i++) {
      GarbageCollector garbageCollector = new GarbageCollector("Garbage Collector " + i);
    }
  }

  @Test
  public void makeObjectReferencesToEachOther() {
    GarbageCollector garbageCollector1 = new GarbageCollector("Garbage Collector 1");
    GarbageCollector garbageCollector2 = new GarbageCollector("Garbage Collector 2");

    GarbageCollector garbageCollector3 = new GarbageCollector("Garbage Collector 3");
    GarbageCollector garbageCollector4 = new GarbageCollector("Garbage Collector 4");

    garbageCollector1.garbageCollectorReference = garbageCollector2;
    garbageCollector3.garbageCollectorReference = garbageCollector4;

    garbageCollector2 = null;
    garbageCollector3 = null;
    System.gc();
  }

  @Test
  public void makeObjectReferencesToEachOther1() {
    GarbageCollector garbageCollector1 = new GarbageCollector("Garbage Collector Save Reference");

    garbageCollector1 = null;
    System.gc();
  }
}
