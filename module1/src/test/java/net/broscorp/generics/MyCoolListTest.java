package net.broscorp.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class MyCoolListTest {

  private MyCoolList<Integer> myCoolList;

  @BeforeEach
  public void setUp() {
    myCoolList = new MyCoolList<>();
  }

  @Test
  public void addAndSizeTest() {
    for (int i = 0; i < 15; i++) {
      myCoolList.add(new Random().nextInt(10 - 1) + 1);
    }
    assertEquals(15, myCoolList.size());
  }

  @Test
  public void mapTest() {
    for (int i = 0; i < 15; i++) {
      myCoolList.add(new Random().nextInt(10 - 1) + 1);
    }

    Function<Integer, Integer> func = x -> x * 2;

    MyCoolList<Integer> newCoolList = myCoolList.map(func);

    int expected = myCoolList.get(3) * 2;

    Assertions.assertEquals(expected, newCoolList.get(3));
  }

  @Test
  public void removeTest() {
    for (int i = 0; i < 15; i++) {
      myCoolList.add(new Random().nextInt(10 - 1) + 1);
    }

    for (int i = 0; i < myCoolList.size(); i++) {
        if(i == 7) {
           myCoolList.remove(i);
        }
    }

    Assertions.assertEquals(14, myCoolList.size());
  }

  @Test
  public void getTest() {
    for (int i = 0; i < 15; i++) {
      int elem = i + 1;
      myCoolList.add(elem);
    }

    Assertions.assertEquals(7, myCoolList.get(6));
  }
}
