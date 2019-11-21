package net.broscorp.h_generics;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  static MyCoolList<Integer> myList;

  @BeforeAll
  public static void initialize() {
    myList = new MyCoolList<Integer>();
  }

  /**
   * Testing Adding function on the MyCoolList
   */
  @Test
  void testAdd() {
    myList.add(1);
    assertTrue(1 == myList.get(0));
  }

  /**
   * Testing Get function on the MyCoolList
   */
  @Test
  void testGet() {
    myList.add(1);
    assertEquals(1, myList.get(0));
  }

  /**
   * Testing Remove function on the MyCoolList
   */
  @Test
  void testRemove() {
    myList.add(1);
    assertEquals(1, myList.remove(0));
  }

  /**
   * Testing Size function on the MyCoolList
   */
  @Test
  void testSize() {
    myList.add(1);
    assertEquals(1, myList.size());
  }

  /**
   * Testing expanding function on the MyCoolList
   */
  @Test
  void testExpandingList() {
    for (int i = 0; i <= 10; i++) {
      myList.add(i);
    }
    assertEquals(11, myList.size());
  }

  /**
   * Testing NullPointerException throwing during Null adding to the MyCoolList
   */
  @Test
  void testExceptionAddingNull() {
    assertThrows(NullPointerException.class, () -> myList.add(null));
  }

  /**
   * Testing IndexOutOfBoundExeption throwing during Get execution on the MyCoolList
   */
  @Test
  void testExceptionTestingGet() {
    for (int i = 0; i <= 2; i++) {
      myList.add(i);
    }
    assertThrows(IndexOutOfBoundsException.class, () -> myList.get(3));
  }

  /**
   * Testing IndexOutOfBoundExeption throwing during Remove execution on the MyCoolList
   */
  @Test
  void testExceptionTestingRemove() {
    for (int i = 0; i <= 2; i++) {
      myList.add(i);
    }
    assertThrows(IndexOutOfBoundsException.class, () -> myList.remove(3));
  }

  /**
   * Testing Map function by converting Integer into Double values on the MyCoolList
   */
  @Test
  void testMapIntegerToDouble() {
    myList.add(1);
    MyCoolList<Double> doubleList = myList.map(intValue -> intValue.doubleValue());
    assertEquals(1.0, doubleList.get(0));
  }

}
