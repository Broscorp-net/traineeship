package net.broscorp.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  private static MyCoolList<Integer> myCoolList;

  @BeforeEach
  public void setup() {
    myCoolList = new MyCoolList<>();
    myCoolList.add(10);
  }

  @Test
  void add() {
    Assertions.assertEquals(10, myCoolList.get(0));
  }

  @Test
  void get() {
    Assertions.assertEquals(10, myCoolList.get(0));
  }

  @Test
  void remove() {
    Assertions.assertEquals(myCoolList.remove(0), 10);
  }

  @Test
  void map() {
    MyCoolList<Long> list = myCoolList.map(i -> 10L * 2);
    Assertions.assertEquals(20, list.get(0));
  }

  @Test
  void size() {
    Assertions.assertEquals(1, myCoolList.size());
  }
}
