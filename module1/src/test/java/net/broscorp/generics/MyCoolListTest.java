package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  private static int EL_1 = 1;
  private static int EL_2 = 2;
  private static int EL_3 = 3;
  private static int SIZE = 3;
  private MyCoolList list;

  @BeforeEach
  void init() {
    list = new MyCoolList<>();

    list.add(EL_1);
    list.add(EL_2);
    list.add(EL_3);
  }


  @Test
  void add() {

    assertEquals(EL_1, list.get(0));
    assertEquals(EL_2, list.get(1));
    assertEquals(EL_3, list.get(2));
  }

  @Test
  void get() {

    assertEquals(EL_1, list.get(0));
    assertEquals(null, list.get(25));
    assertEquals(null, list.get(17));

  }

  @Test
  void remove() {

    list.remove(0);
    assertEquals(EL_2, list.get(0));
    assertEquals(EL_3, list.get(1));
    assertEquals(null, list.get(2));
    assertEquals(null, list.get(3));

  }

  @Test
  void map() {
    MyCoolList<Integer> mapped = list.map(x -> x);
    assertEquals(EL_1, mapped.get(0));
    assertEquals(EL_2, mapped.get(1));
    assertEquals(EL_3, mapped.get(2));
  }

  @Test
  void size() {
    assertEquals(SIZE, list.size());
  }
}