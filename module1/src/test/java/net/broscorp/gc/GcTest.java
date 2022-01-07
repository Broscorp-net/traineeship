package net.broscorp.gc;

import org.junit.jupiter.api.Test;

class GcTest {

  @Test
  void manyObjectsTest() {

    for (int j = 0; j < 10_000_000; j++) {
        CountedObj c = new CountedObj();
        c = null;
    }

    System.out.println("During the course of creating 10M objects, "
        + CountedObj.finalized + " were finalized.");

  }

  @Test
  void makeReachableTest() {
    CountedObj.makeReachable = true;
    CountedObj c = new CountedObj();
    c = null;
    System.gc();
    System.gc();
  }

  @Test
  void crossReferenceTest () {

    CountedObj c = new CountedObj();
    c.referencing = new CountedObj();
    c = null;
    System.gc();
  }
}