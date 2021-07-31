package net.broscorp.generics;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MyCoolListTest {

  @Test
  void add() {
    MyCoolList<Integer> list = new MyCoolList<>();

    list.add(5);

    assertTrue(5 == list.get(0));
  }

  @Test
  void get() {
    MyCoolList<Integer> list = new MyCoolList<>();

    list.add(5);

    assertTrue(5 == list.get(0));
  }

  @Test
  void remove() {
    MyCoolList<Integer> list = new MyCoolList<>();

    list.add(5);

    assertTrue(5 == list.get(0));

    list.remove(0);

    try {
      list.get(0);
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  void map() {
    MyCoolList<Integer> list = new MyCoolList<>();
    Function<Integer, Integer> function = x -> x * x;
    list.add(1);
    list.add(2);
    list.add(3);

    MyCoolList<Integer> newList = list.map(function);

    for (int i = 1; i <= 3; i++) {

      assertTrue(Math.pow(i, 2) == newList.get(i - 1));
    }
  }

  @Test
  void size() {
    MyCoolList<Integer> list = new MyCoolList<>();
    list.add(1);
    list.add(2);
    list.add(3);

    assertTrue(3 == list.size());
  }
}
