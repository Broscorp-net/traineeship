package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;
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
    integerMyCoolList.removeElem(0);
    assertNotEquals(removed, integerMyCoolList.get(0));
  }

  @Test
  void removeLast() {
    integerMyCoolList.add(2);

    Integer removed = integerMyCoolList.get(integerMyCoolList.size() - 1);
    integerMyCoolList.removeElem(integerMyCoolList.size() - 1);
    assertNotEquals(removed, integerMyCoolList.get(integerMyCoolList.size() - 1));
  }


  @Test
  void removeBetween() {
    integerMyCoolList.add(2);
    integerMyCoolList.add(3);

    Integer removed = integerMyCoolList.get(1);
    integerMyCoolList.removeElem(1);
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


  @Test
  void iterator() {
    integerMyCoolList.add(10);
    integerMyCoolList.add(20);
    integerMyCoolList.add(3);

    Iterator<Integer> iterator = integerMyCoolList.iterator();
    while (iterator.hasNext()) {
      if (iterator.next() % 2 == 0) {
        iterator.remove();
      }
    }

    assertEquals(2, integerMyCoolList.size());
  }
}