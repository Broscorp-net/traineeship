/*
 * Copyright (c) 2021-2021.
 * Danylo Havrylchenko
 * GitHub: @akellanotavailable
 */

package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
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

    assertEquals(min, myCoolList.get(2));
  }

  @Test
  void removeNegativeTest() {
    myCoolList.add(5);
    myCoolList.add(42);
    myCoolList.add(-25);
    myCoolList.add(0);

    Iterator<Integer> iterator = myCoolList.iterator();
    while (iterator.hasNext()) {
      if (iterator.next() < 0) {
        iterator.remove();
      }
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

    assertEquals(newCoolList.get(3), myCoolList.get(3));
  }

  @Test
  void sizeTest() {
    myCoolList.add(5);
    myCoolList.add(42);
    myCoolList.add(-25);
    myCoolList.add(0);

    assertEquals(4, myCoolList.size());

    Iterator<Integer> iterator = myCoolList.iterator();
    while (iterator.hasNext()) {
      if (iterator.next() <= 0) {
        iterator.remove();
      }
    }

    assertEquals(2, myCoolList.size());

    myCoolList.add(0);

    assertEquals(3, myCoolList.size());
  }

}