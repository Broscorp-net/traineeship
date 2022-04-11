package net.broscorp.generics;

import java.util.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Iterator testing.
 */
class MyCoolListTest {
  private static final MyCoolList<Integer> myCoolList = new MyCoolList<>();

  static {
    for (int i = 0; i < 10; i++) {
      myCoolList.add(i);
    }
  }

  @Test
  void checkIterator() {
    int countIteration = 0;
    int countValue = 0;
    for (int n : myCoolList) {
      Assertions.assertEquals(countIteration, n);
      countIteration++;
      countValue += n;
    }
    Assertions.assertEquals(10, countIteration);
    Assertions.assertEquals(45, countValue);
  }

  @Test
  void checkRemoveWhileIteration() {
    Iterator<Integer> iterator = myCoolList.iterator();
    iterator.remove();
    Assertions.assertEquals(9, myCoolList.size());
  }
}