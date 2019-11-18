package net.broscorp.h_generics;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class MyCoolList1Test {


  @SuppressWarnings("rawtypes")
  private static List myList;


  @SuppressWarnings("rawtypes")
  @BeforeAll

  public static void initialize() {
    myList = new MyCoolList1();
  }

  // Checking for adding element into List
  @SuppressWarnings("unchecked")
  @Test
  void testAdd() {
    myList.add(1);
    assertEquals(1,myList.get(0));
  }

  // IndexOutOfBound, during adding new element
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

  // Get function checking
  @SuppressWarnings("unchecked")
  @Test
  void testGet() {
    myList.add((Object) 1);
    myList.add((Object) 2);
    myList.add((Object) 3);
    assertEquals(3, myList.get(2));
  }

  // IndexOutOfBoundException during Get operation under element index of which are  exceeded List size
  @SuppressWarnings("unchecked")
  @Test
  void exceptionTestingGet() {
    myList.add((Object) 1);
    myList.add((Object) 2);
    myList.add((Object) 3);
    assertThrows(IndexOutOfBoundsException.class, () -> myList.get(3));
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

  // IndexOutOfBoundException during Remove operation under element index of which are  exceeded List size
  @SuppressWarnings("unchecked")
  @Test
  void exceptionTestingRemove() {
    myList.add((Object) 1);
    myList.add((Object) 2);
    myList.add((Object) 3);
    assertThrows(IndexOutOfBoundsException.class, () -> myList.remove(3));
  }

  //  Checking inversion between Object -> Integer for Map function
  @SuppressWarnings("unchecked")
  @Test
  void testMap() {
    FunctionClass function = new FunctionClass();
    myList.add((Object) 22.999999);
    Object myObject = myList.get(0);
    assertEquals(22, function.apply(myObject));
  }

  // Checking Map function for NullPointerException.
  @SuppressWarnings("unchecked")
  @Test
  void exceptionTestingMap() {
    FunctionClass function = new FunctionClass();
    myList.add(null);
    Object myObject = myList.get(0);
    assertThrows(NullPointerException.class, () -> function.apply(myObject));
  }

}
