package net.broscorp.gc;

import org.junit.jupiter.api.Test;

class ListTest {


  @Test
  void createALargeNumberOfObjectsTest() {
    for (int i = 0; i < 1000_000; i++) {
      new List(null, i, i);
    }
  }

  @Test
  void createObjectsSaveReferenceTest() {
    Object[] arr = new Object[0];
    for (int i = 0; i < 1000_000; i++) {
      new List(arr, i, i);
    }
    System.out.println("arr.length = " + arr.length);
  }


  @Test
  void checkReferencingObjectsTest() {
    Object[] arr = new Object[0];
    for (int i = 0; i < 1000_000; i++) {
      List firstList = new List(arr, i, i);
      List secondList = new List(arr, i, i);
      firstList.setList(secondList);
      secondList.setList(firstList);
    }
  }


}