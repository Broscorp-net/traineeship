/*
 * Copyright (c) 2021-2021.
 * Danylo Havrylchenko
 * GitHub: @akellanotavailable
 */

package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MyCoolListTest {

  MyCoolList<Integer> myCoolList = new MyCoolList<>();

  @Test
  void addTest() {
    myCoolList.add(1);
    myCoolList.add(2);
    myCoolList.add(3);

    Integer sum = 0;
    for (Integer i : myCoolList) {
      sum += i;
    }

    assertEquals(6, sum);
  }

  @Test
  void getMinTest() {
    myCoolList.add(5);
    myCoolList.add(42);
    myCoolList.add(-25);
    myCoolList.add(0);

    Integer min = Integer.MAX_VALUE;

    for (Integer i : myCoolList) {
      min = Math.min(min, i);
    }

    assertEquals(-25, min);
  }

  @Test
  void removeNegativeTest() {
    myCoolList.add(5);
    myCoolList.add(42);
    myCoolList.add(-25);
    myCoolList.add(0);

    int index = 0;
    for (Integer i : myCoolList) {
      if (i < 0) {
        myCoolList.remove(index);
      }
      index++;
    }

    assertEquals(3, myCoolList.size());
  }

  @Test
  void mapOddTest() {
    myCoolList.add(5);
    myCoolList.add(42);
    myCoolList.add(-25);
    myCoolList.add(0);

    MyCoolList<Integer> newCoolList = myCoolList.map((Integer item) -> {
      if (item % 2 == 0) {
        item *= item;
      } else {
        item -= 1;
      }
      return item;
    });

    assertEquals(newCoolList.get(4), myCoolList.get(4));
  }

  @Test
  void sizeTest() {
    myCoolList.add(5);
    myCoolList.add(42);
    myCoolList.add(-25);
    myCoolList.add(0);

    assertEquals(4, myCoolList.size());

    int index = 0;
    for (Integer i : myCoolList) {
      if (i <= 0) {
        myCoolList.remove(index);
      }
      index++;
    }

    assertEquals(2, myCoolList.size());

    myCoolList.add(0);

    assertEquals(3, myCoolList.size());
  }

  @Test
  void iteratorTest() {

  }

}