package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyCoolListIteratorTest {

  private static MyCoolList<Integer> list;

  @BeforeEach
  void listInit() {
    list = new MyCoolList<>();
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
  }

  @Test
  public void shouldReturnIterator() {
    //given
    Iterator<Integer> iterator = list.iterator();
    //when
    //then
    assertNotNull(iterator);
  }

  @Test
  public void shouldReturnTrueIfElementExists() {
    //given
    Iterator<Integer> iterator = list.iterator();
    //when
    //then
    assertTrue(iterator.hasNext());
  }

  @Test
  public void shouldReturnFalseIfElementDoesNotExist() {
    //given
    Iterator<Integer> iterator = new MyCoolList<Integer>().iterator();
    //when
    //then
    assertFalse(iterator.hasNext());
  }

  @Test
  public void shouldIterateOverList() {
    //given
    Iterator<Integer> iterator = list.iterator();
    List<Integer> result = new ArrayList<>();
    //when
    while (iterator.hasNext()) {
      result.add(iterator.next());
    }
    //then
    assertNotEquals(0, result.size());
    for (Integer i : list) {
      assertTrue(result.contains(i));
    }
  }

  @Test
  public void shouldRemoveOneElement() {
    //given
    Iterator<Integer> iterator = list.iterator();
    int sizeBefore = list.size();
    //when
    iterator.remove();
    //then
    assertEquals(sizeBefore - 1, list.size());
    assertEquals(1, list.get(0));
  }

  @Test
  public void shouldRemoveAllElements() {
    //given
    Iterator<Integer> iterator = list.iterator();
    //when
    while (iterator.hasNext()) {
      iterator.remove();
    }
    //then
    assertEquals(0, list.size());
  }

}
