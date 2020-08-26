package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

class MyCoolListTest {

  private Function<Integer, Long> function;
  private MyCoolList<Integer> myCoolList;
  private int size;

  @BeforeEach
  void setUp() {
    function = integer -> integer.longValue() * 2;
    myCoolList = new MyCoolList<>();
    size = 20;

    for (int i = 0; i < size; i++) {
      myCoolList.add(i);
    }
  }

  @Test
  void addTest() {
    Integer integer = 10000;
    myCoolList.add(integer);

    assertEquals(integer, myCoolList.get(myCoolList.size()-1));
    assertEquals(size + 1, myCoolList.size());
  }

  @Test
  void getTest() {
    for (int i = size - 1; i >= 0; i--) {
      assertEquals(i, myCoolList.get(i));
    }
  }

  @Test
  void getExceptionTest() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      myCoolList.get(100);
    });
  }

  @Test
  void removeTest() {
    myCoolList.remove(10);
    assertEquals(size - 1, myCoolList.size());
  }

  @Test
  void badRemoveTest() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      myCoolList.remove(200);
    });
  }

  @Test
  void mapTest() {
    MyCoolList <Number> longMyCoolList = myCoolList.map(function);

    for (int i = 0; i < longMyCoolList.size(); i++) {
      assertTrue(longMyCoolList.get(i) instanceof Long);
    }
  }

  @Test
  void sizeTest() {
    assertEquals(size, myCoolList.size());
  }
}