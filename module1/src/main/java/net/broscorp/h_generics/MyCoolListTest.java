package net.broscorp.h_generics;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class MyCoolListTest {


  @SuppressWarnings("rawtypes")
  private static List myList;


  @SuppressWarnings("rawtypes")
  @BeforeAll

  public static void initialize() {
    myList = new MyCoolList();
  }

  // Adding function checking
  @SuppressWarnings("unchecked")
  @Test
  void testAdd() {
    myList.add(1);
    assertTrue((Object) 1 == myList.get(0));
  }

  // IndexOutOfBoundException checking during adding
  @SuppressWarnings("unchecked")
  @Test
  void exceptionTestingAdd() {
    myList.add(1);
    myList.add(1);
    myList.add(1);
    myList.add(1);
    myList.add(1);
    myList.add(1);
    myList.add(1);
    myList.add(1);
    myList.add(1);
    myList.add(1);
    assertThrows(IndexOutOfBoundsException.class, () -> myList.add(1));
  }

  // Get Function checking
  @SuppressWarnings("unchecked")
  @Test
  void testGet() {
    myList.add((Object) 1);
    myList.add((Object) 2);
    myList.add((Object) 3);
    assertEquals(3, myList.get(2));
  }

  // OutOfBoundException during get operation
  @SuppressWarnings("unchecked")
  @Test
  void exceptionTestingGet() {
    myList.add((Object) 1);
    myList.add((Object) 2);
    myList.add((Object) 3);
    assertThrows(IndexOutOfBoundsException.class, () -> myList.get(5));
  }


  // Removing function checking
  @SuppressWarnings("unchecked")
  @Test
  void testRemove() {
    myList.add((Object) 1);
    myList.add((Object) 2);
    myList.add((Object) 3);
    assertEquals(2, myList.remove(1));
  }

  // OutOfBoundException checking during removing
  @SuppressWarnings("unchecked")
  @Test
  void exceptionTestingRemove() {
    myList.add((Object) 1);
    myList.add((Object) 2);
    myList.add((Object) 3);
    assertThrows(IndexOutOfBoundsException.class, () -> myList.remove(5));
  }

  // Map function checking
  @SuppressWarnings("unchecked")
  @Test
  void testMap() {
    FunctionClass function = new FunctionClass();
    myList.add((Object) 22.999999);
    Object myObject = myList.get(0);
    assertEquals(22, function.apply(myObject));
  }

  // NullPointerException checking during mapping
  @SuppressWarnings("unchecked")
  @Test
  void exceptionTestingMap() {
    FunctionClass function = new FunctionClass();
    myList.add(null);
    Object myObject = myList.get(0);
    assertThrows(NullPointerException.class, () -> function.apply(myObject));
  }

}
