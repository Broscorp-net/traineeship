package net.broscorp.h_generics;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.Function;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  @Test
  void testGet() {
    MyCoolList<Integer> myList = new MyCoolList<>();
    myList.add(2);
    assertEquals(2, myList.get(0));
  }


  @Test
  void testRemove() {
    MyCoolList<Integer> myList = new MyCoolList<>();
    myList.add(1);
    assertEquals(1, myList.remove(0));
    assertEquals(0, myList.size());
  }

  @Test
  void testSize() {
    MyCoolList<Integer> myList = new MyCoolList<>();
    myList.add(1);
    assertEquals(1, myList.size());
  }


  @Test
  void testExpandingList() {
    MyCoolList<Integer> myList = new MyCoolList<>();
    for (int i = 0; i <= 10; i++) {
      myList.add(i);
    }
    assertEquals(11, myList.size());
  }


  @Test
  void testExceptionAddingNull() {
    MyCoolList<Integer> myList = new MyCoolList<>();
    assertThrows(IllegalArgumentException.class, () -> myList.add(null));
  }


  @Test
  void testExceptionTestingGet() {
    MyCoolList<Integer> myList = new MyCoolList<>();
    for (int i = 0; i <= 2; i++) {
      myList.add(i);
    }
    assertThrows(IndexOutOfBoundsException.class, () -> myList.get(3));
  }

  @Test
  void testExceptionTestingRemove() {
    MyCoolList<Integer> myList = new MyCoolList<>();
    for (int i = 0; i <= 2; i++) {
      myList.add(i);
    }
    assertThrows(IndexOutOfBoundsException.class, () -> myList.remove(3));
  }

  @Test
  void testMapIntegerToDouble() {
    MyCoolList<Integer> intList = new MyCoolList<>();
    intList.add(12);
    Function<Integer, Double> function = Integer::doubleValue;
    MyCoolList<Double> doubleList = intList.map(function);
    assertEquals(intList.size(), doubleList.size());
  }

}