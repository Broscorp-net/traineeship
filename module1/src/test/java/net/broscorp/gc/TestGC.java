package net.broscorp.gc;

import org.junit.jupiter.api.Test;

public class TestGC {

  protected static RestorationWaste restorationWaste;
  protected static Waste waste;

  @Test
  public void createALotWaste() {
    for (int i = 0; i < 10000; i++) {
      new Waste(i);
    }
  }

  @Test
  public void createRestorationWaste() {
    for (int i = 0; i < 10; i++) {
      new RestorationWaste(i);
    }
    System.gc();
    System.gc();
  }

  @Test
  public void createWasteReference() {
    for (int i = 0; i < 10; i++) {
      new WasteReference(i, new Waste(i));
    }
    System.gc();
    waste = new Waste(100);
    for (int i = 10; i < 20; i++) {
      new WasteReference(i, waste);
    }
    System.gc();
  }
}
