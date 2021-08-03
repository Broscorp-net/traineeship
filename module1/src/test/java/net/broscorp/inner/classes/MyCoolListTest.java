package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class MyCoolListTest {

  @Test
  void iteratorInAction() {
    MyCoolList<Integer> list = new MyCoolList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    Iterator<Integer> iterator = list.iterator();

    for (int i = 0; i < list.size(); i++) {

      assertEquals(iterator.next(), list.get(i));
    }
  }

  @Test
  void iteratorWithNoSuchElementsException() {
    MyCoolList<Integer> list = new MyCoolList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    Iterator<Integer> iterator = list.iterator();
    try {
      for (int i = 0; i <= list.size(); i++) {
        iterator.next();
      }
    } catch (Exception e) {
      assertEquals(new NoSuchElementException().getMessage(), e.getMessage());
    } finally {
      System.out.println("Got it");
    }
  }

  @Test
  void iteratorNotExist() {
    Iterator iterator = new MyCoolList<Integer>().iterator();
    assertFalse(iterator.hasNext());
  }

  @Test
  void iteratorSize() {
    MyCoolList<Integer> list = new MyCoolList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    Iterator<Integer> iterator = list.iterator();
    for (int i = 0; i < list.size(); i++) {
      assertEquals(iterator.next(), list.get(i));
    }
  }
}
