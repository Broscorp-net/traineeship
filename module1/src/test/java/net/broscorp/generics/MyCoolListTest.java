package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  private MyCoolList<Integer> myCoolList;

  @BeforeEach
  void setUp() {
    myCoolList = new MyCoolList<>();
    for (int i = 0; i < 10; i++) {
      myCoolList.add(i);
    }
  }


  @Test
  void add() {
    myCoolList.add(50);
    assertEquals(50, myCoolList.listInt.get(myCoolList.listInt.size() - 1));
  }

  @Test
  void get() {
    //index in range
    assertEquals(5, myCoolList.get(5));
    //index out iof range
    assertEquals("Wrong index", myCoolList.get(20));
  }

  @Test
  void remove() {
    // correct index
    assertEquals(4, myCoolList.remove(4));
    // size of List decreased to 1
    assertEquals(9, myCoolList.listInt.size());
    // wrong index
    assertEquals("Wrong index", myCoolList.remove(10));
  }

  @Test
  void size() {
    assertEquals(10, myCoolList.size());
  }

  @Test
  void iteratorTest() {
    int index = 0;
    while (myCoolList.iterator.hasNext()) {
      // test hasNext()
      assertTrue(myCoolList.iterator.hasNext());
      assertEquals(myCoolList.get(index), index);
      myCoolList.iterator.next();
      index++;
    }
    for (int i = 0; i < 10; i++) {
      myCoolList.iterator.remove();
    }
  }

}