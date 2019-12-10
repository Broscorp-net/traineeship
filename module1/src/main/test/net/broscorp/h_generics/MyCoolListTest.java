package net.broscorp.h_generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  private MyCoolList<Integer> myList;

  @BeforeEach
  void setUp() {
    myList = new MyCoolList<>();
  }

  @Test
  void testAddElement() {
    myList.add(10);
    assertEquals(10, myList.get(0));
  }

  @Test
  void testGetElement() {
    for (int i = 0; i < 10; i++) {
      myList.add(i);
    }
    assertEquals(2, myList.get(2));
  }

  @Test
  void testGetElementNegativeIndex() {
    for (int i = 0; i < 10; i++) {
      myList.add(i);
    }
    assertThrows(IndexOutOfBoundsException.class, () -> myList.get(-1));
  }

  @Test
  void testGetElementIndexOutOfBounds() {
    for (int i = 0; i < 10; i++) {
      myList.add(i);
    }
    assertThrows(IndexOutOfBoundsException.class, () -> myList.get(12));
  }

  @Test
  void testRemoveElement() {
    for (int i = 0; i < 10; i++) {
      myList.add(i);
    }
    myList.remove(1);
    assertEquals(2, myList.get(1));
  }

  @Test
  void testRemoveElementIndexOutOfBounds() {
    for (int i = 0; i < 10; i++) {
      myList.add(i);
    }
    assertThrows(IndexOutOfBoundsException.class, () -> myList.remove(12));
  }

  @Test
  void testMapIntegerToDouble() {
    myList.add(30);
    Function<Integer, Double> function = aDouble -> (Double) aDouble.doubleValue();
    List<Double> listDouble = myList.map(function);
    assertEquals(30.0, listDouble.get(0));
  }

  @Test
  void testMapIntegerToString() {
    myList.add(30);
    Function<Integer, String> function = aString -> (String) aString.toString();
    List<String> listDouble = myList.map(function);
    assertEquals("30", listDouble.get(0));
  }

  @Test
  void testIteratorHasNextTrue() {
    myList.add(30);
    Iterator<Integer> iterator = myList.iterator();
    assertTrue(iterator.hasNext());
  }

  @Test
  void testIteratorHasNextFalse() {
    Iterator<Integer> iterator = myList.iterator();
    assertFalse(iterator.hasNext());
  }

  @Test
  void testIteratorNext() {
    myList.add(30);
    myList.add(50);
    Iterator<Integer> iterator = myList.iterator();
    List<Integer> list = new ArrayList<>();
    while (iterator.hasNext()) {
      list.add(iterator.next());
    }

    assertEquals(30, list.get(0));
    assertEquals(50, list.get(1));
  }

  @Test
  void testIteratorNextThrowException() {
    Iterator<Integer> iterator = myList.iterator();
    assertThrows(NoSuchElementException.class, iterator::next);
  }

  @Test
  void testIteratorRemove() {
    myList.add(50);
    Iterator<Integer> iterator = myList.iterator();
    iterator.remove();

    assertThrows(IndexOutOfBoundsException.class, () -> myList.get(0));
  }

  @Test
  void testIteratorRemoveExceptionIfNothingRemove() {
    Iterator<Integer> iterator = myList.iterator();
    assertThrows(ConcurrentModificationException.class, iterator::remove);
  }
}