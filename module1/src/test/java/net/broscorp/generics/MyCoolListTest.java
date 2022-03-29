package net.broscorp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  private MyCoolList<Integer> myCoolList;

  @BeforeEach
  public void setUp() {
    myCoolList = new MyCoolList<>();
    for (int i = 0; i < 15; i++) {
      myCoolList.add(i + 1);
    }
  }

  @Test
  public void addAndSizeTest() {
    myCoolList.add(16);
    Assertions.assertEquals(16, myCoolList.size());
  }

  @Test
  public void mapTest() {
    Function<Integer, Integer> func = x -> x * 2;

    MyCoolList<Integer> newCoolList = myCoolList.map(func);

    int expected = myCoolList.get(3) * 2;

    Assertions.assertEquals(expected, newCoolList.get(3));
  }

  @Test
  public void removeTest() {
    for (int i = 0; i < myCoolList.size(); i++) {
      if (i == 7) {
        myCoolList.remove(i);
      }
    }

    Assertions.assertEquals(14, myCoolList.size());
  }

  @Test
  public void getTest() {
    Assertions.assertEquals(7, myCoolList.get(6));
  }

  @Test
  public void nullTest() {
    myCoolList.add(null);
    Assertions.assertNull(myCoolList.get(15));
  }
}
