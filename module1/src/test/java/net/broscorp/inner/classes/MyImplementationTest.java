package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;

import net.broscorp.generics.MyCoolList;

import org.junit.jupiter.api.Test;

class MyImplementationTest {

  MyCoolList<Integer> integers;

  @Test
  void addTest() {
    integers = new MyImplementation<>();
    integers.add(1);
    assertEquals(1, integers.get(0));
  }

  @Test
  void getTest() {
    integers = new MyImplementation<>();
    integers.add(1);
    assertEquals(1, integers.get(0));
    assertThrows(IndexOutOfBoundsException.class, () -> integers.get(5));
  }

  @Test
  void removeItemTest() {
    integers = new MyImplementation<>();
    integers.add(1);
    integers.add(2);
    Integer removed = integers.get(0);
    integers.removeOneItem(0);
    assertNotEquals(removed, integers.get(0));
  }

  @Test
  void mapTest() {
    integers = new MyImplementation<>();
    integers.add(1);
    MyCoolList<Integer> mapped = integers.map(x -> x * 5);
    assertEquals(5, mapped.get(0));
  }

  @Test
  void sizeTest() {
    integers = new MyImplementation<>();
    integers.add(1);
    assertEquals(1, integers.size());
  }


  @Test
  void iterator() {
    integers = new MyImplementation<>();
    integers.add(1);
    integers.add(6);
    integers.add(12);
    integers.add(5);

    Iterator<Integer> iterator = integers.iterator();
    while (iterator.hasNext()) {
      if (iterator.next() % 2 == 0) {
        iterator.remove();
      }
    }
    assertEquals(2, integers.size());
  }
}
