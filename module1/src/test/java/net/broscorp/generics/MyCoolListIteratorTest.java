package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyCoolListIteratorTest {

  private MyCoolList<Integer> myCoolList;
  private Iterator<Integer> myCoolListIterator;

  @BeforeEach
  void initMyTestInstancesForEachTest() {
    int randomArraySize = new Random().nextInt(5) + 2;
    myCoolList = new MyCoolList<>();
    for (int i = 0; i < randomArraySize; i++) {
      myCoolList.add(new Random().nextInt(10));
    }
    myCoolListIterator = myCoolList.iterator();
  }

  @Test
  public void checkCreatingMyCoolListIteratorInstanceTest() {
    assertNotNull(myCoolListIterator);
    assertEquals(MyCoolList.MyCoolListIterator.class, myCoolListIterator.getClass());
  }

  @Test
  public void checkMethodHasNextOfMyCoolListIteratorTest() {
    for (int i = 0; i < myCoolList.size() - 1; i++) {
      myCoolListIterator.next();
      assertTrue(myCoolListIterator.hasNext());
    }
    myCoolListIterator.next();
    assertFalse(myCoolListIterator.hasNext());
  }

  @Test
  public void checkMethodNextOfMyCoolListIteratorTest() {
    int i = 0;
    while (myCoolListIterator.hasNext()) {
      assertEquals(myCoolList.get(i), myCoolListIterator.next());
      i++;
    }
  }

  @Test
  public void checkMethodRemoveOfMyCoolListIteratorTest() {
    int indexElementToRemove = new Random().nextInt(myCoolList.size());
    int oldMyCoolListSize = myCoolList.size();
    Integer nextElementAfterElementToRemove = myCoolList.get(indexElementToRemove + 1);
    int i = 0;
    while (myCoolListIterator.hasNext()) {
      myCoolListIterator.next();
      if (i == indexElementToRemove) {
        myCoolListIterator.remove();
        break;
      }
      i++;
    }
    assertEquals(nextElementAfterElementToRemove, myCoolList.get(indexElementToRemove));
    assertEquals(oldMyCoolListSize - 1, myCoolList.size());
  }
}
