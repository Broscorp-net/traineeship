package net.broscorp.generics;

import java.util.function.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  @Test
  void create() {
    MyCoolList<Integer> myCoolListEmpty = new MyCoolList<>();
    MyCoolList<Integer> myCoolList = new MyCoolList<>(100);
    Assertions.assertEquals(0, myCoolListEmpty.size());
    Assertions.assertEquals(0, myCoolList.size());
  }

  @Test
  void add() {
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
    for (int i = 0; i < 10; i++) {
      myCoolList.add(i);
    }
    Assertions.assertEquals(10, myCoolList.size());
  }

  @Test
  void get() {
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
    for (int i = 0; i < 2; i++) {
      myCoolList.add(i);
      Assertions.assertEquals(i, myCoolList.get(i));
    }
    Assertions.assertThrows(IndexOutOfBoundsException.class,
        () -> myCoolList.get(myCoolList.size() + 1));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myCoolList.get(-1));
  }

  @Test
  void remove() {
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
    for (int i = 0; i < 2; i++) {
      myCoolList.add(i);
    }
    Assertions.assertEquals(0, myCoolList.remove(0));
    Assertions.assertEquals(1, myCoolList.size());
  }

  @Test
  void map() {
    Function<Integer, Integer> func = x -> x * 2;
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
    for (int i = 0; i < 10; i++) {
      myCoolList.add(i);
    }
    MyCoolList<Integer> myCoolListSecond = myCoolList.map(func);
    Assertions.assertEquals(0, myCoolListSecond.get(0));
    Assertions.assertEquals(12, myCoolListSecond.get(6));
    Assertions.assertEquals(10, myCoolListSecond.size());
  }
}