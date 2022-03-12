package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MyCoolListTest {

  @Test
  public void createdListWithDefaultCapacity() {
    MyCoolList<Integer> coolList = new MyCoolList<>();
    assertEquals(0, coolList.size());
  }

  @Test
  public void createdListWithUserCapacity() {
    MyCoolList<Integer> coolList = new MyCoolList<>(10);
    assertEquals(0, coolList.size());
  }

  @Test
  public void createdListUserCapacityNegativeNumber() {
    assertThrows(IllegalArgumentException.class, () -> {
      MyCoolList<Integer> coolList = new MyCoolList<>(-1);
    });
  }

  @Test
  public void addNumber() {
    MyCoolList<Integer> coolList = new MyCoolList<>();
    coolList.add(2);
    coolList.add(1);
    assertEquals(2, coolList.size());
    assertEquals(2, coolList.get(0));
    assertEquals(1, coolList.get(1));
  }

  //Default Capacity - 16;
  @Test
  public void addGreaterThanDefaultCapacity() {
    MyCoolList<Integer> coolList = new MyCoolList<>();
    for (int i = 0; i < 200; i++) {
      coolList.add(i);
    }
    assertEquals(200, coolList.size());
    assertEquals(150, coolList.get(150));
  }

  @Test
  public void get() {
    MyCoolList<Integer> coolList = new MyCoolList<>();
    coolList.add(1);
    assertEquals(1, coolList.size());
    assertEquals(1, coolList.get(0));
  }

  @Test
  public void getThrowIndexOfBonusException() {
    MyCoolList<Integer> coolList = new MyCoolList<>();
    assertThrows(IndexOutOfBoundsException.class, () -> coolList.get(-1));
  }

  @Test
  void remove() {
    MyCoolList<Integer> coolList = new MyCoolList<>();
    for (int i = 0; i < 10; i++) {
      coolList.add(i);
    }
    assertEquals(coolList.remove(1), 1);
    assertEquals(2, coolList.get(1));
    assertEquals(9, coolList.size());
  }

  @Test
  void map() {
    MyCoolList<Integer> coolList = new MyCoolList<>();
    for (int i = 0; i < 10; i++) {
      coolList.add(i);
    }
    MyCoolList<Integer> mapCoolList = coolList.map(x -> x * 10);

    assertEquals(10, mapCoolList.size());
    assertEquals(0, mapCoolList.get(0));
    assertEquals(10, mapCoolList.get(1));
    assertEquals(90, mapCoolList.get(9));
  }
}