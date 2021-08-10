package net.broscorp.inner.classes;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  @Test
  public void myIteratorTest() {
    MyCoolList<Integer> myCoolList = new MyCoolList<>(5);
    myCoolList.add(2);
    myCoolList.add(4);
    myCoolList.add(6);
    myCoolList.add(8);
    int count = 0;
    for (Integer integer : myCoolList) {
      Assertions.assertEquals(integer, myCoolList.get(count));
      count++;
    }
  }

  @Test
  public void myIteratorNextHasNextTest() {
    MyCoolList<Integer> myCoolList = new MyCoolList<>(5);
    myCoolList.add(3);
    myCoolList.add(5);
    myCoolList.add(7);
    myCoolList.add(9);
    List<Integer> list = new ArrayList<>();
    while (myCoolList.iterator().hasNext()) {
      Integer next = myCoolList.iterator().next();
      list.add(next);
    }
    int expected = myCoolList.size();
    int actual = list.size();
    Assertions.assertEquals(expected, actual);
  }
}