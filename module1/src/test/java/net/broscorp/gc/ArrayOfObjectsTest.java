package net.broscorp.gc;

import org.junit.jupiter.api.Test;

public class ArrayOfObjectsTest {

  @Test
  void addObjectsTest() {
    ArrayOfObjects.numberOfObjects = 0;
    ArrayOfObjects.finalizeObjets = 0;
    for (int i = 0; i < 10_000_000; i++) {

      ArrayOfObjects array = new ArrayOfObjects(i);
    }
    System.out.println("Total objects: " + ArrayOfObjects.numberOfObjects);
    System.out.println("Objects finalized : " + ArrayOfObjects.finalizeObjets);
  }

  @Test
  void restoreObjectsTest() throws InterruptedException {
    ArrayOfObjects.numberOfObjects = 0;
    ArrayOfObjects.finalizeObjets = 0;
    RestoreObjects arrayRestore = new RestoreObjects(1000);
    arrayRestore = null;
    System.out.println("Calling GC");
    System.gc();
    Thread.sleep(5000);
    System.out.println("Restore object is " + arrayRestore.myArrayRestore.getNum());
  }

  @Test
  void linkedObjectsTest() {
    ArrayOfObjects.numberOfObjects = 0;
    ArrayOfObjects.finalizeObjets = 0;
    ArrayOfObjects array1 = new ArrayOfObjects(1);
    ArrayOfObjects array2 = new ArrayOfObjects(2);

    array1.myArray = array2;
    array2.myArray = array1;
  }
}
