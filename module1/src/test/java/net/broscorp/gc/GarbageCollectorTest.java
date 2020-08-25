package net.broscorp.gc;

import org.junit.jupiter.api.Test;

public class GarbageCollectorTest {

  @Test
  public void testCG() {
    printUsedMemory();

    Developer dev;
    for (int i = 0; i < 100_000; i++) {
      dev = new Developer(i);
//      System.out.printf("Developer=%d was created\n", dev.getId());
    }

    printUsedMemory();
  }

  @Test
  public void testCGWithDeletingReferenceToObject() {
    printUsedMemory();

    Developer dev;
    for (int i = 0; i < 100_000; i++) {
      dev = new Developer(i);
//      System.out.printf("Developer=%d was created\n", dev.getId());
      dev = null;
    }

    printUsedMemory();
  }

  @Test
  public void testCGAliveAfterFinalize() throws InterruptedException {
    TestObject testObject = new TestObject();
    testObject.developer2 = new Developer2(testObject);
    testObject.developer2 = null; // Developer2 become unreachable，finalize will be invoked

    System.gc(); // invoking Garbage collector

    if (testObject.developer2 != null) {
      System.out.println("MyObject still alive!");
    }

    Thread.sleep(1000);
    // will not work because finalize methods are commented
    // Assertions.assertNotNull(testObject.developer2);
  }

  @Test
  public void testCGWithCyclicReference() throws InterruptedException {
    Developer first = new Developer(1, null);
    Developer second = new Developer(2, first);
    first.setNext(second);

    // still referring to each other
    first = null;
    second = null;

    System.gc(); // invoking Garbage collector
  }

  private void printUsedMemory() {
    Runtime r = Runtime.getRuntime();
    long usedMemory = r.totalMemory() - r.freeMemory();
    System.out.println("Used memory (bytes): " + usedMemory);
  }
}
