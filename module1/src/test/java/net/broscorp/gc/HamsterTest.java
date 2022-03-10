package net.broscorp.gc;

import org.junit.jupiter.api.Test;

public class HamsterTest {

  @Test
  public void spamObjectsTest() {
    for (int i = 0; i < 100000; i++) {
      Hamster object = new Hamster("Hamster #" + i);
      object = null;
    }
  }

  @Test
  public void referencedObjectsTest() {
    Hamster gavrila = new Hamster("Gavrila");
    Hamster peter = new Hamster("Peter");
    Hamster fred = new Hamster("Fred");
    gavrila.friend = peter;
    //Peter will stay in memory, because he is referenced by friend field of Gavrila
    peter = null;
    //Fred is gone
    fred = null;
    System.gc();
    //Now when Gavrila is gone too, both Peter and Gavrila will be erased by gc()
    gavrila = null;
    System.gc();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void selfReferencingDuringFinalizeTest() {
    Hamster testsubject = new Hamster("Test Subject");
    testsubject = null;
    System.gc();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
