package net.broscorp.inner.classes;

import java.util.Iterator;
import net.broscorp.generics.MyCoolList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InnerClassesTests {

  @Test
  void testAdding() {
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
    myCoolList.add(6);
    Assertions.assertEquals(myCoolList.get(0), 6);
  }

  @Test
  void testRemoving() {
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
    for (int i = 0; i < 5; i++) {
      myCoolList.add(i);
    }
    Assertions.assertEquals(myCoolList.remove(4), 4);
    Assertions.assertEquals(myCoolList.remove(0), 0);
    Assertions.assertEquals(myCoolList.remove(1), 2);
  }

  @Test
  void testMapping() {
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
    for (int i = 0; i < 5; i++) {
      myCoolList.add(i);
    }
    myCoolList = myCoolList.map((it) -> it * 2);
    Assertions.assertEquals(myCoolList.get(4), 8);
  }

  @Test
  void testSize() {
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
    for (int i = 0; i < 5; i++) {
      myCoolList.add(i);
    }
    Assertions.assertEquals(myCoolList.size(), 5);
  }

  @Test
  void testHasNext() {
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
    Iterator<Integer> iterator = myCoolList.iterator();

    myCoolList.add(0);

    Assertions.assertTrue(iterator.hasNext());
    Assertions.assertEquals(iterator.next(), 0);
    Assertions.assertFalse(iterator.hasNext());
  }

  @Test
  void testRemove() {
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
    Iterator<Integer> iterator = myCoolList.iterator();

    myCoolList.add(0);

    Assertions.assertTrue(iterator.hasNext());
    iterator.remove();
    Assertions.assertFalse(iterator.hasNext());
  }

  @Test
  void testEndOfList() {
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
    Iterator<Integer> iterator = myCoolList.iterator();

    Assertions.assertNull(iterator.next());
  }
}
