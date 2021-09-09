package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import net.broscorp.inner.classes.MyCoolList.InnerIterator;
import org.junit.jupiter.api.BeforeEach;
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
  void increaseSizeOfMyCoolList() {
    assertEquals(10, myCoolList.size());
    myCoolList.add(20);
    assertEquals(11, myCoolList.size());
  }

  @Test
  void iterator() {
    InnerIterator iterator = myCoolList.iterator();
    assertEquals(InnerIterator.class, iterator.getClass());
    int sizeOfList = 0;
    while (iterator.hasNext()) {
      iterator.next();
      sizeOfList++;
    }
    assertEquals(10, sizeOfList);
  }


  @Test
  void map() {
  }

}