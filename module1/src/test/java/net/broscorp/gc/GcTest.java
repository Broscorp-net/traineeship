package net.broscorp.gc;

import org.junit.jupiter.api.Test;

public class GcTest {

  @Test
  public void createManyObjectsTest() {
    System.out.println("First iteration");

    for (int i = 1; i < 1001; i++) {
      GcObject gcObject = new GcObject(i);
      gcObject = null;
    }

    System.out.println("Second iteration");
    System.gc();
  }

  @Test
  void removeAndRecoveryObject() {
    System.out.println("First iteration");

    GcObject gcObject1 = new GcObject(1);
    GcObject gcObject2 = new GcObject(2);
    gcObject2 = null;

    System.out.println("Second iteration");
    gcObject2 = gcObject1;
    gcObject2 = null;
    System.gc();
    gcObject2 = gcObject1;
    gcObject2 = null;
    System.gc();
  }

  @Test
  void linkToEachOtherTest() {
    System.out.println("First iteration");

    GcObject gcObject1 = new GcObject(1);
    GcObject gcObject2 = new GcObject(2);

    gcObject1 = gcObject2;
    gcObject2 = gcObject1;

    System.out.println("Second iteration");

    gcObject1 = null;
    gcObject2 = null;

    System.gc();
  }
}
