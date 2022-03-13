package net.broscorp;

import org.junit.jupiter.api.Test;

class MyTest {

  NonKillingObject nonKillingObject;

  @Test
  void testGC() {
    int count = 0;
    for (int i = 0; i < 204000; i++) {
      TestObject testObject = new TestObject(count++);
    }
  }

  @Test
  void testLinkedObject() {
    TestLinkedObjectA objectA = new TestLinkedObjectA();
    objectA = null;
    System.gc();
  }

  @Test
  void testNonKillingObject() throws InterruptedException {
    nonKillingObject = new NonKillingObject();
    System.out.println("First try to delete object");
    nonKillingObject = null;
    System.gc();

    Thread.sleep(10000);

    if (nonKillingObject == null) {
      System.out.println("Object killed");
    } else {
      System.out.println("Object still alive");
    }

    System.out.println("Second try to delete object");
    nonKillingObject = null;
    Thread.sleep(10000);

    if (nonKillingObject == null) {
      System.out.println("Object killed");
    } else {
      System.out.println("Object still alive");
    }
  }

  static class TestObject {

    int numberOfObject;

    public TestObject(int i) {
      this.numberOfObject = i;
    }

    @Override
    protected void finalize() throws Throwable {
      System.out.println("Object " + numberOfObject + " collected by GC");
    }
  }

  static class TestLinkedObjectA {

    private TestLinkedObjectB objectB;

    public TestLinkedObjectA() {
      objectB = new TestLinkedObjectB(this);
    }

    @Override
    protected void finalize() throws Throwable {
      System.out.println("Object A collected by GC");
    }

  }

  static class TestLinkedObjectB {

    private TestLinkedObjectA objectA;

    public TestLinkedObjectB(TestLinkedObjectA objectA) {
      this.objectA = objectA;
    }

    @Override
    protected void finalize() throws Throwable {
      System.out.println("Object B collected by GC");
    }
  }

  class NonKillingObject {

    @Override
    protected void finalize() {
      nonKillingObject = this;
    }
  }
}