package net.broscorp.generics;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  @Test
  void createNew() {
    MyCoolList<Integer> list = new MyCoolList<>();
    Assertions.assertTrue(true);
  }

  @Test
  void addFirstElement() {
    MyCoolList<Integer> list = new MyCoolList<>();
    Integer i = 1;
    list.add(i);
    Assertions.assertTrue(true);
  }

  @Test
  void addSubsequentElement() {
    MyCoolList<Integer> list = new MyCoolList<>();
    Integer numObj = 1;
    list.add(numObj);
    list.add(numObj);
    Assertions.assertTrue(true);
  }

  @Test
  void addManyElements() {
    MyCoolList<Integer> list = new MyCoolList<>();
    Integer numObj = 1;
    for (int i = 0; i < 10; i++) {
      list.add(numObj);
    }
    Assertions.assertTrue(true);
  }

  @Test
  void getExistingElement() {
    MyCoolList<Integer> list = new MyCoolList<>();
    int checkedIndex = 3;
    Integer checkedNumObj = 2;
    Integer numObj = 1;
    for (int i = 0; i < checkedIndex; i++) {
      list.add(numObj);
    }
    list.add(checkedNumObj);
    for (int i = 1; i <= 5; i++) {
      list.add(numObj);
    }
    Object obj = list.get(3);
    Assertions.assertEquals(obj, checkedNumObj);
  }

  @Test
  void getWhenIndexOverSize() {
    MyCoolList<Integer> list = new MyCoolList<>();
    Integer numObj = 1;
    list.add(numObj);
    list.add(numObj);
    list.add(numObj);
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      list.get(20);
    });
  }

  @Test
  void getWhenIndexNegative() {
    MyCoolList<Integer> list = new MyCoolList<>();
    Integer numObj = 1;
    list.add(numObj);
    list.add(numObj);
    list.add(numObj);
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      list.get(-1);
    });
  }

  @Test
  void testRemove() {
    MyCoolList<Integer> list = new MyCoolList<>();
    Integer numObj = 1;
    list.add(numObj);
    list.add(numObj);
    list.add(numObj);

    list.remove(1);

    Assertions.assertEquals(list.size(), 2);
  }

  @Test
  void testMap() {
    MyCoolList<Integer> list = new MyCoolList<>();
    Integer numObj = 1;
    list.add(numObj);
    MyCoolList<Integer> mappedList = list.map(x -> x * 5);
    Assertions.assertEquals(5,mappedList.get(0));
  }

  @Test
  void testIteratorNext() {
    MyCoolList<Integer> list = new MyCoolList<>();
    Integer numObj = 1;
    list.add(numObj);
    list.add(numObj);
    list.add(numObj);

    int count = 0;
    for (Object o : list) {
      count++;
    }
    Assertions.assertEquals(count, 3);
  }

  @Test
  void testIteratorRemove() {
    MyCoolList<Integer> list = new MyCoolList<>();
    Integer numObj = 1;
    list.add(numObj);
    list.add(numObj);
    list.add(numObj);

    Iterator iter = list.iterator();
    iter.next();
    iter.next();
    iter.remove();

    Assertions.assertEquals(list.size(), 2);
  }
}