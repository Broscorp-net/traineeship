package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  private MyCoolList<Integer> myCoolList;

  @BeforeEach
  void setUp() {
    myCoolList = new MyCoolList<>();
    myCoolList.listInt.add(5);
    myCoolList.listInt.add(10);
  }

  @Test
  void add() {
    myCoolList.add(23);
    myCoolList.add(null);
    assertEquals(23, myCoolList.listInt.get(2));
    assertNull(myCoolList.listInt.get(3));
  }

  @Test
  void size() {
    assertEquals(2, myCoolList.size());
  }

  @Test
  void get() {
    //index in range
    assertEquals(5, myCoolList.get(0));
    assertEquals(10, myCoolList.get(1));
    //index out iof range
    assertEquals("Wrong index", myCoolList.get(10));
  }

  @Test
  void remove() {
    // correct index
    assertEquals(5, myCoolList.remove(0));
    // size of List decreased to 1
    assertEquals(1, myCoolList.listInt.size());
    // wrong index
    assertEquals("Wrong index", myCoolList.remove(10));
  }
}