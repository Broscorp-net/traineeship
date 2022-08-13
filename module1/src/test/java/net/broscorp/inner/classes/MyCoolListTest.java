package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  private MyCoolList<Integer> myCoolList1;
  private MyCoolList<Integer> myCoolList2;

  @BeforeEach
  void setUp() {
    myCoolList1 = new MyCoolList<>();
    myCoolList2 = new MyCoolList<>();
  }

  @Test
  void hasNext() {
    myCoolList2.add(1);
    myCoolList2.add(5);
    myCoolList2.add(10);

    MyCoolList<Integer>.MyCoolListIterator iterator1 = myCoolList1.iterator();
    MyCoolList<Integer>.MyCoolListIterator iterator2 = myCoolList2.iterator();

    assertFalse(iterator1.hasNext());
    assertTrue(iterator2.hasNext());
  }

  @Test
  void next() {
    myCoolList1.add(2);
    myCoolList1.add(4);
    myCoolList1.add(6);
    MyCoolList<Integer>.MyCoolListIterator iterator = myCoolList1.iterator();

    assertEquals(2, iterator.next().intValue());
    assertEquals(4, iterator.next().intValue());
    assertEquals(6, iterator.next().intValue());
  }
}