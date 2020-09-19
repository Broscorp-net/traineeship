package net.broscorp.gc;

import java.util.ArrayList;
import java.util.List;

public class GarbageCollectorTest {

  private static void createObjectWithReferenceToEachOther() {
    for (int i = 0; i < 1_000_000; i++) {
      ObjectForGarbaCollector firstGC = new ObjectForGarbaCollector();
      ObjectForGarbaCollector secondGC = new ObjectForGarbaCollector();
      secondGC.setGc(firstGC);
      firstGC.setGc(secondGC);
      firstGC = null;
      secondGC = null;
    }
  }

  private static void createObjectsWithoutReference() {
    for (int i = 0; i < 1_000_000; i++) {
      new ObjectForGarbaCollector();
    }
  }

  private static void createImmortalObjects() {
    List<ImmortalObjectForGarbageCollector> list = new ArrayList<>();
    for (int i = 0; i < 1_000_000; i++) {
      new ImmortalObjectForGarbageCollector(list);
    }
  }

  public static void main(String[] args) {}
}
