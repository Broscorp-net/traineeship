package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyImplementationTest {
  MyCoolList<Integer> myCoolList;

  @Test
  void add() {
    myCoolList = new MyImplementation<>();
    myCoolList.add(1);
    assertEquals(1, myCoolList.get(0));
  }

  @Test
  void get() {
    myCoolList = new MyImplementation<>();
    myCoolList.add(1);
    assertEquals(1, myCoolList.get(0));
  }

  @Test
  void map() {
    myCoolList = new MyImplementation<>();
    myCoolList.add(1);
    MyCoolList<Integer> mapped = myCoolList.map(x -> x * 5);
    assertEquals(5, mapped.get(0));
  }

  @Test
  void size() {
    myCoolList = new MyImplementation<>();
    myCoolList.add(1);
    assertEquals(1, myCoolList.size());
  }
}
