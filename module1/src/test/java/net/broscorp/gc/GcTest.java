package net.broscorp.gc;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class GcTest {

  @Test
  void whenDoNotLooseObjectReferences() {
    List<GCMain> list = new ArrayList<>(10_000_000);
    for (int i = 0; i < 20_000_000; i++) {
      GCMain gcMain = new GCMain();
      list.add(gcMain);
    }
  }

  @Test
  void whenLooseObjectReference() {
    List<GCMain> list = new ArrayList<>(10_000_000);
    for (int i = 0; i < 20_000_000; i++) {
      GCMain gcMain = new GCMain();
    }
  }

  @Test
  void twoObjectsReferencesEachOther() {
    GCMain one = new GCMain();
    GCMain two = new GCMain();
    one = two;
    two = one;
  }

  @Test
  void afterFinalizeAchievableObjects() {
    GCMain one = new GCMain();
    GCMain two = new GCMain();
    one = two;
    two = one;
    System.out.println("This is the two object: " + two);
  }
}