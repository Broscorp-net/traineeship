package net.broscorp;

import net.broscorp.generics.MyCoolList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyTest {

  @Test
  void testAdding() {
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
    myCoolList.add(6);
    Assertions.assertEquals(myCoolList.get(0), 6);
  }

  @Test
  void testRemoving() {
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
    for (int i = 0; i < 5; i++) {
      myCoolList.add(i);
    }
    Assertions.assertEquals(myCoolList.remove(4), 4);
    Assertions.assertEquals(myCoolList.remove(0), 0);
    Assertions.assertEquals(myCoolList.remove(1), 2);
  }

  @Test
  void testMapping() {
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
    for (int i = 0; i < 5; i++) {
      myCoolList.add(i);
    }
    myCoolList = myCoolList.map((it) -> it * 2);
    Assertions.assertEquals(myCoolList.get(4), 8);
  }

  @Test
  void testSize() {
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
    for (int i = 0; i < 5; i++) {
      myCoolList.add(i);
    }
    Assertions.assertEquals(myCoolList.size(), 5);
  }
}