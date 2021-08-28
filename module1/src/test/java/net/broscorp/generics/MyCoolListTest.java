package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  private MyCoolList<Integer> myCoolList;

  @BeforeEach
  void setUp() {
    int size = 10;
    myCoolList = new MyCoolList<>(size);
    for (int i = 0; i < size; i++) {
      myCoolList.add(i);
    }
  }

  @Test
  void add() {
    myCoolList.add(23);
    myCoolList.add(null);
    assertEquals(23, myCoolList.get(10));
    assertNull(myCoolList.get(11));
    assertEquals(12, myCoolList.size());
  }

  @Test
  void size() {
    assertEquals(10, myCoolList.size());
  }

  @Test
  void get() {
    //index in range
    assertEquals(5, myCoolList.get(5));
    //index out of range
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> myCoolList.get(20));
  }

  @Test
  void remove() {
    //index in range
    assertEquals(6, myCoolList.remove(6));
    // size of List decreased by 1
    assertEquals(9, myCoolList.size());
    //index out of range
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> myCoolList.get(20));
  }

  @Test
  void increaseSizeOfList() {
    assertEquals(10, myCoolList.size());
    myCoolList.add(20);
    assertEquals(11, myCoolList.size());
  }

  @Test
  @DisplayName("Mapped Integer Collection to Double")
  void mapTest() {
    MyCoolList<Double> myDoubleList = myCoolList.map(f -> f * 1.);
    assertEquals(4.0, myDoubleList.get(4));
    assertEquals(10, myDoubleList.size());
  }
}