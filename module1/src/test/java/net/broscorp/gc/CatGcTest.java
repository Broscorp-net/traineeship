package net.broscorp.gc;

import org.junit.jupiter.api.Test;

public class CatGcTest {

  @Test
  void createDeleteCatsReferences() { //gc cleaning starts after creating a lot of objects
    for (int i = 0; i < 30_000; i++) {
      Cat cat = new Cat(i);
      cat = null;
    }
  }

  @Test
  void createCatsReferencesSysGc() throws InterruptedException { //gc cleaning starts earlier
    for (int i = 0; i < 1000; i++) {
      Cat cat = new Cat(i);
      cat = null;
    }

    System.gc();

    Thread.sleep(3_000);
  }

  static CatRef REF; //initialization in finalize method

  @Test
  void makeObjectReachableAgain() throws InterruptedException {
    CatRef cat = new CatRef(1);

    cat = null;
    System.gc(); //gc cleans cat with id 1
    Thread.sleep(3_000);
    System.out.println("after first run");
    System.out.println("Reference: " + REF);

    REF = null;
    System.gc();//gc do not clean cat with id 1, gc cleans the same object only once
    Thread.sleep(3000);
    System.out.println("after second run");
  }

}
