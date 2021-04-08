package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyCoolListTest {

  private MyCoolList<Integer> myCoolList;

  @BeforeEach
  void initMyCoolListInstanceForEachTest() {
    int randomArraySize = new Random().nextInt(5) + 2;
    myCoolList = new MyCoolList<>();
    for (int i = 0; i < randomArraySize; i++) {
      myCoolList.add(i);
    }
  }

  @Test
  public void checkCreatingMyCoolListInstanceTest() {
    MyCoolList<Integer> newCoolList = new MyCoolList<>();
    assertNotNull(newCoolList);
    assertEquals(0, newCoolList.size());
  }

  @Test
  public void checkAddToMyCoolListTest() {
    int oldMyCoolListSize = myCoolList.size();
    myCoolList.add(20);
    assertEquals(oldMyCoolListSize + 1, myCoolList.size());
  }

  @Test
  public void checkGetFromMyCoolListTest() {
    for (int i = 0; i < myCoolList.size(); i++) {
      assertEquals(i, myCoolList.get(i));
    }
  }

  @Test
  public void getNullWhenIndexOutOfBoundsTest() {
    assertNull(myCoolList.get(myCoolList.size()));
    assertNull(myCoolList.get(myCoolList.size() / (-2)));
  }

  @Test
  public void checkRemoveFromMyCoolListTest() {
    int oldMyCoolListSize = myCoolList.size();
    for (int i = 0; i < oldMyCoolListSize; i++) {
      assertEquals(i, myCoolList.remove(0));
      assertEquals(oldMyCoolListSize - (i + 1), myCoolList.size());
    }
  }

  @Test
  public void returnNullWhenRemoveAndIndexOutOfBoundsTest() {
    assertNull(myCoolList.remove(myCoolList.size()));
    assertNull(myCoolList.remove(myCoolList.size() / (-2)));
  }

  @Test
  public void checkMapOfMyCoolListTest() {
    MyCoolList<Double> myDoubleCoolList = myCoolList.map(Math::sqrt);
    assertEquals(myCoolList.size(), myDoubleCoolList.size());
    for (int i = 0; i < myCoolList.size(); i++) {
      assertEquals(Double.class, myDoubleCoolList.get(i).getClass());
      assertEquals(Math.sqrt(myCoolList.get(i)), myDoubleCoolList.get(i));
    }
  }
}
