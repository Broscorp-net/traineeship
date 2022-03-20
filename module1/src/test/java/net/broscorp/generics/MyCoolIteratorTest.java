package net.broscorp.generics;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyCoolIteratorTest {
  private MyCoolList<Integer> myCoolList;
  private Iterator<Integer> iterator;

  /**
   * Some dummy javadoc for checkstyle.
   */
  @BeforeEach
  public void setUp() {
    myCoolList = new MyCoolList<>();

    for (int i = 0; i < 15; i++) {
      int temp = i + 1;
      myCoolList.add(temp);
    }
    iterator = myCoolList.iterator();
  }

  @Test
  public void hasNextTest() {
    Assertions.assertTrue(iterator.hasNext());
  }

  @Test
  public void nextTest() {
    Assertions.assertEquals(1, iterator.next());
  }

  @Test
  public void countTest() {
    int counter = 0;

    while (iterator.hasNext()) {
      counter = iterator.next();
    }

    Assertions.assertEquals(myCoolList.size(), counter);
  }
}
