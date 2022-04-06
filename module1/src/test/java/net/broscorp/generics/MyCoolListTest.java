package net.broscorp.generics;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyCoolListTest {
  private MyCoolList<Integer> list = new MyCoolList<>();

  @Test
  void checkAddAndSize() {
    list.add(2);
    System.out.println(list.get(0));
    assertTrue(list.size() == 1);
  }

  @Test
  void checkGet() {
    int a = 8;
    list.add(a);
    assertEquals(a, list.get(0));
  }

  @Test
  void checkRemove() {
    list.add(2);
    list.add(5);
    list.add(10);
    list.remove(2);
    assertTrue(list.size() == 2);
  }

}