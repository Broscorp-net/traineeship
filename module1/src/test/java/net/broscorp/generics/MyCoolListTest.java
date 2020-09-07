package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

}
