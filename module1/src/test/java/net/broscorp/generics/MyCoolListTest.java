package net.broscorp.generics;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyCoolListTest {
  private static MyCoolList<Integer> list =  new MyCoolList<>();

  @BeforeAll
  static void fill() {
    list.add(2);
    list.add(4);
    list.add(6);
  }

  @Test
  public void checkIterable() {
    for (Object i : list) {
      System.out.println(i);
    }
  }

}