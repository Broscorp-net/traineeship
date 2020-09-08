package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

public class MyCoolListTest {

  @Test
  void add() {
    MyCoolList<Integer> list = new MyCoolList<>();

    list.add(10);
    list.add(13);
    list.add(1);
    list.add(5);

    assertEquals(10, list.get(0));
    assertEquals(5, list.get(3));
    assertEquals(4, list.size());
  }

  @Test
  void addWithNull() {
    MyCoolList<Integer> list = new MyCoolList<>();

    list.add(null);
    list.add(183);

    assertEquals(2, list.size());
    assertNull(list.get(0));
    assertEquals(183, list.get(1));
  }

  @Test
  void getWithIncorrectIndex() {
    MyCoolList<Long> list = new MyCoolList<>();

    for (long i = 0; i < 100; i++) {
      list.add(i);
    }

    assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()));
  }

  @Test
  void removeWithIncorrectIndex() {
    MyCoolList<Long> list = new MyCoolList<>();

    for (long i = 0; i < 30; i++) {
      list.add(i);
    }

    assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()));
  }

  @Test
  void getWithCorrectIndex() {
    MyCoolList<Long> list = new MyCoolList<>();

    for (long i = 0; i < 100; i++) {
      list.add(i);
    }

    assertEquals(0, list.get(0));
    assertEquals(99, list.get(list.size() - 1));
    assertEquals(50, list.get(list.size() / 2));
  }

  @Test
  void removeWithCorrectIndex() {
    MyCoolList<Long> list = new MyCoolList<>();

    for (long i = 0; i < 30; i++) {
      list.add(i);
    }

    assertEquals(0, list.get(0));
    assertEquals(0, list.remove(0));
    assertEquals(1, list.get(0));
    assertEquals(29, list.remove(list.size() - 1));
    assertEquals(28, list.get(list.size() - 1));
    assertEquals(3, list.remove(2));
    assertEquals(27, list.size());
  }

  @Test
  void size() {
    final MyCoolList<Byte> listB = new MyCoolList<>();
    final MyCoolList<Integer> emptyList = new MyCoolList<>();

    for (byte i = 0; i < 30; i++) {
      listB.add(i);
    }

    listB.remove(0);
    listB.remove(6);
    listB.remove(3);
    listB.add((byte)3);

    assertEquals(28, listB.size());
    assertEquals(0, emptyList.size());
  }

  @Test
  void removeFromAnEmptyList() {
    MyCoolList<Byte> list = new MyCoolList<>();

    assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
  }

  @Test
  void getFromAnEmptyList() {
    MyCoolList<Byte> list = new MyCoolList<>();

    assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
  }

  @Test
  void mapWithCorrectFunctions() {
    MyCoolList<Integer> list = new MyCoolList<>();

    list.add(1);
    list.add(-10);
    list.add(15);

    MyCoolList<Integer> listMulEleven = list.map((elem) -> elem * 11);
    MyCoolList<Byte> listConvToByte = list.map((elem) -> elem.byteValue());

    assertEquals(list.size(), listMulEleven.size());
    assertEquals(list.size(), listConvToByte.size());
    assertEquals(-110, listMulEleven.get(1));
    assertEquals(165, listMulEleven.get(2));
    assertEquals(11, listMulEleven.get(0));
    assertNotNull(listConvToByte.get(0));
  }

  @Test
  void mapWithNullFunction() {
    MyCoolList<Integer> list = new MyCoolList<>();
    MyCoolList<Integer> newList = new MyCoolList<>();

    list.add(11);
    list.add(21);

    newList = list.map(null);

    assertEquals(2, list.size());
    assertEquals(0, newList.size());
    assertFalse(newList == list);
  }

  @Test
  void mapOnAnEmptyList() {
    MyCoolList<Byte> list = new MyCoolList<>();
    MyCoolList<Byte> newList;

    newList = list.map((elem) -> elem);

    assertFalse(newList == list);
    assertEquals(0, newList.size());
  }

  @Test
  void iterateOverList() {
    final MyCoolList<Integer> list = new MyCoolList<>();
    final List<Integer> arrList = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      list.add(i * 3);
    }

    for (Integer elem : list) {
      arrList.add(elem);
    }

    assertEquals(10, list.size());
    assertEquals(arrList.size(), list.size());
    assertEquals(arrList.get(9), list.get(9));
    assertEquals(arrList.get(5), list.get(5));
  }

  @Test
  void iterateOverEmptyList() {
    MyCoolList<Integer> list = new MyCoolList<>();
    int acc = 0;

    for (Integer elem : list) {
      acc += elem;
    }

    assertEquals(0, acc);
  }

  @Test
  void forEachWithNullFunc() {
    MyCoolList<Integer> list = new MyCoolList<>();

    for (int i = 0; i < 10; i++) {
      list.add(i * 3);
    }

    assertThrows(NullPointerException.class, () -> list.forEach(null));
  }

  @Test
  void forEachWithCorrectFunc() {
    MyCoolList<Integer> list = new MyCoolList<>();
    List<Integer> arrList = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      list.add(i * 3);
    }

    list.forEach(arrList::add);

    assertEquals(arrList.size(), list.size());
    assertEquals(arrList.get(3), list.get(3));
  }

  @Test
  void compareMyListWithArrListThroughIterator() {
    MyCoolList<Integer> myList = new MyCoolList<>();
    List<Integer> arrList = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      myList.add(i * 3);
      arrList.add(i * 3);
    }

    Iterator<Integer> it1 = myList.iterator();
    Iterator<Integer> it2 = arrList.iterator();

    while (it1.hasNext() && it2.hasNext()) {
      assertEquals(it1.next(), it2.next());
    }

    assertEquals(myList.size(), arrList.size());
  }

  @Test
  void iteratorRemoveWithoutCallingNext() {
    MyCoolList<Integer> myList = new MyCoolList<>();
    myList.add(3);

    Iterator<Integer> it = myList.iterator();

    assertThrows(IllegalStateException.class, it::remove);
  }

  @Test
  void iteratorRemoveTwoTimesInARow() {
    MyCoolList<Integer> myList = new MyCoolList<>();
    myList.add(3);
    myList.add(3);
    myList.add(3);

    Iterator<Integer> it = myList.iterator();
    it.next();
    it.remove();

    assertThrows(IllegalStateException.class, it::remove);
  }

  @Test
  void iteratorRemoveCorrectly() {
    MyCoolList<Integer> myList = new MyCoolList<>();
    myList.add(3);
    myList.add(-1);
    myList.add(0);
    Iterator<Integer> it = myList.iterator();

    it.next();
    it.remove();
    it.next();
    it.remove();

    assertEquals(1, myList.size());
    assertEquals(0, myList.get(0));
    assertThrows(IndexOutOfBoundsException.class, () -> myList.get(1));
  }

  @Test
  void iteratorRemoveOnEmptyList() {
    MyCoolList<Integer> myList = new MyCoolList<>();
    Iterator<Integer> it = myList.iterator();

    assertThrows(IllegalStateException.class, it::remove);
  }

  @Test
  void iteratorNextOnEmptyList() {
    MyCoolList<Integer> myList = new MyCoolList<>();
    Iterator<Integer> it = myList.iterator();

    assertThrows(NoSuchElementException.class, it::next);
  }

  @Test
  void iteratorNextOnLastElement() {
    MyCoolList<Integer> myList = new MyCoolList<>();
    myList.add(3);

    Iterator<Integer> it = myList.iterator();
    it.next();

    assertThrows(NoSuchElementException.class, it::next);
  }

  @Test
  void iteratorHasNextOnEmptyList() {
    MyCoolList<Integer> myList = new MyCoolList<>();

    Iterator<Integer> it = myList.iterator();

    assertFalse(it.hasNext());
  }

}
