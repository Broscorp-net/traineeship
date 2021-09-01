package net.broscorp.gc;

import org.junit.jupiter.api.Test;

public class CatGcTest {

  @Test
  void createDeleteCatsReferences() { //gc cleaning starts after creating a lot of objects
    for (int i = 0; i < 300_000; i++) {
      Cat cat = new Cat(i);
      cat = null;
    }
  }

  @Test
  void createCatsReferencesSysGc() { //gc cleaning starts earlier
    for (int i = 0; i < 1000; i++) {
      Cat cat = new Cat(i);
      cat = null;
    }

    System.gc();
  }

  static Cat REF; //initialization in finalize method

  @Test
  void makeObjectReachableAgain() {
    Cat cat = new Cat(1);

    cat = null;

    System.gc(); //gc cleans cat with id 1

    REF = null;

    System.gc();//gc do not clean cat with id 1, gc cleans the same object only once
  }

}
