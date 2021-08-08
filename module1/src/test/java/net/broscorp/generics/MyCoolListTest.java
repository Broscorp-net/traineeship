package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MyCoolListTest {

  MyCoolList<Integer> myCoolList = new MyCoolList<>();

  @Test
  void addTest() {
    myCoolList.add(4);
    assertEquals(4, myCoolList.get(0));
  }

  @Test
  void getTest() {
    myCoolList.add(4);
    assertEquals(4, myCoolList.get(0));
    assertThrows(IndexOutOfBoundsException.class, () -> myCoolList.get(1000));
  }

  /**
   * Test for removal.
   */
  @Test
  void removeTest() {
    myCoolList.add(4);
    assertEquals(4, myCoolList.get(0));
    myCoolList.remove(0);
    assertThrows(IndexOutOfBoundsException.class, () -> myCoolList.get(0));
  }

  @Test
  void mapTest() {
    myCoolList.add(1);
    myCoolList.add(2);
    myCoolList.add(3);
    myCoolList.add(4);
    myCoolList.add(5);

    myCoolList = myCoolList.map((Integer x) -> x * x);

    assertEquals(25, myCoolList.get(4));
  }

  @Test
  void sizeTest() {
    myCoolList.add(1);
    myCoolList.add(2);
    myCoolList.add(3);
    myCoolList.add(4);
    myCoolList.add(5);

    assertEquals(5, myCoolList.size());

    myCoolList.remove(0);
    myCoolList.remove(0);

    assertEquals(3, myCoolList.size());
  }
}