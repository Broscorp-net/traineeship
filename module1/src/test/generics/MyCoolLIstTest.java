package net.broscorp.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  @Test
  void createNew() {
    MyCoolList list = new MyCoolList();
    Assertions.assertTrue(true);
  }

  @Test
  void addFirstElement() {
    MyCoolList list = new MyCoolList();
    Integer i = 1;
    list.add(i);
    Assertions.assertTrue(true);
  }

  @Test
  void addSubsequentElement() {
    MyCoolList list = new MyCoolList();
    Integer numObj = 1;
    list.add(numObj);
    list.add(numObj);
    Assertions.assertTrue(true);
  }

  @Test
  void addManyElements() {
    MyCoolList list = new MyCoolList();
    Integer numObj = 1;
    for (int i = 0; i < 10; i++) {
      list.add(numObj);
    }
    Assertions.assertTrue(true);
  }

  @Test
  void GetExistingElement()
  {
    MyCoolList list = new MyCoolList();
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
  void GetWhenIndexOverSize()
  {
    MyCoolList list = new MyCoolList();
    Integer numObj = 1;
    list.add(numObj);
    list.add(numObj);
    list.add(numObj);
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      list.get(20);
    });
  }

  @Test
  void GetWhenIndexNegative()
  {
    MyCoolList list = new MyCoolList();
    Integer numObj = 1;
    list.add(numObj);
    list.add(numObj);
    list.add(numObj);
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      list.get(-1);
    });
  }
}