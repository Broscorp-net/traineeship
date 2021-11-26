package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCoolListImplTest {

  MyCoolList<Integer> integerMyCoolList;

  @BeforeEach
  void setUp() {
    integerMyCoolList = new MyCoolListImpl<>();
    integerMyCoolList.add(1);
  }

  @Test
  void add() {
    assertEquals(1, integerMyCoolList.get(0));
  }

  @Test
  void get() {
    assertEquals(1, integerMyCoolList.get(0));
    assertThrows(IndexOutOfBoundsException.class, () -> integerMyCoolList.get(5));
  }

  @Test
  void removeFirst() {
    integerMyCoolList.add(2);

    Integer removed = integerMyCoolList.get(0);
    integerMyCoolList.remove(0);
    assertNotEquals(removed, integerMyCoolList.get(0));
  }

  @Test
  void removeLast() {
    integerMyCoolList.add(2);

    Integer removed = integerMyCoolList.get(integerMyCoolList.size() - 1);
    integerMyCoolList.remove(integerMyCoolList.size() - 1);
    assertNotEquals(removed, integerMyCoolList.get(integerMyCoolList.size() - 1));
  }


  @Test
  void removeBetween() {
    integerMyCoolList.add(2);
    integerMyCoolList.add(3);

    Integer removed = integerMyCoolList.get(1);
    integerMyCoolList.remove(1);
    assertNotEquals(removed, integerMyCoolList.get(1));
  }

  @Test
  void map() {
    MyCoolList<Integer> mapped = integerMyCoolList.map(x -> x * 3);
    assertEquals(3, mapped.get(0));
  }

  @Test
  void size() {
    assertEquals(1, integerMyCoolList.size());
  }
}