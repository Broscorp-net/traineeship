package net.broscorp.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyCoolListTest {
  private static MyCoolList<Integer> myCoolList;

  @BeforeAll
  static void setup() {
    myCoolList = new MyCoolList<>();
    myCoolList.add(10);
  }

  @Test
  void hasNext() {
    Assertions.assertTrue(myCoolList.iterator().hasNext());
  }

  @Test
  void next() {
    Integer expected = myCoolList.iterator().next();
    Assertions.assertEquals(expected, 10);
  }
}
