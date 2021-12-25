package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import net.broscorp.generics.MyCoolList;
import net.broscorp.generics.MyImplementation;
import org.junit.jupiter.api.Test;

public class MyImplementationTest {
  MyCoolList<Integer> myCoolList;

  @Test
  void addTest() {
    myCoolList = new MyImplementation<>();
    myCoolList.add(1);
    assertEquals(1, myCoolList.get(0));
  }

  @Test
  void getTest() {
    myCoolList = new MyImplementation<>();
    myCoolList.add(1);
    assertEquals(1, myCoolList.get(0));
  }

  @Test
  void mapTest() {
    myCoolList = new MyImplementation<>();
    myCoolList.add(1);
    MyCoolList<Integer> mapped = myCoolList.map(x -> x * 5);
    assertEquals(5, mapped.get(0));
  }

  @Test
  void sizeTest() {
    myCoolList = new MyImplementation<>();
    myCoolList.add(1);
    assertEquals(1, myCoolList.size());
  }
}
