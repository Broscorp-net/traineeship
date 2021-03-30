package net.broscorp.gc;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GarbageCollectionTest {

  @Test
  void checkOnManyObjects() {
    for (int i = 0; i < 500_000; i++) {
      new GarbageColl().setGarbageColl(new GarbageColl());
    }
  }

  @Test
  void linksToEachOther() {
    for (int i = 0; i < 500_000; i++) {
      GarbageColl garbageCollFirst = new GarbageColl();
      GarbageColl garbageCollSecond = new GarbageColl();

      garbageCollFirst.setGarbageColl(garbageCollSecond);
      garbageCollSecond.setGarbageColl(garbageCollFirst);
    }
  }

  @Test
  void restoreObj() {
    List<GarbageCollList> garbageCollList = new ArrayList<>();
    for (int i = 0; i < 500_000; i++) {
      new GarbageCollList(garbageCollList);
    }
  }
}
