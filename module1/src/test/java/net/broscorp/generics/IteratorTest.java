package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IteratorTest {

  private static final int EL_1 = 1;
  private static final int EL_2 = 2;
  private static final int EL_3 = 3;
  private static final int EL_4 = 4;
  private static final int EL_5 = 5;
  private static final int EL_6 = 6;
  private static final int SIZE = 6;
  private static MyCoolList list;

  @BeforeEach
  void init() {
    list = new MyCoolList<>();

    list.add(EL_1);
    list.add(EL_2);
    list.add(EL_3);
    list.add(EL_4);
    list.add(EL_5);
    list.add(EL_6);

  }

  @Test
  void hasNextAndNextTest() {
    Iterator iterator = list.iterator();
    int counter = 0;
    for (int i = 0; ; i++) {
      if (iterator.hasNext()) {
        iterator.next();
        counter++;
      } else {
        break;
      }
    }

    assertEquals(SIZE, counter);
    assertEquals(EL_1, list.get(0));
    assertEquals(EL_2, list.get(1));
    assertEquals(EL_3, list.get(2));
    assertEquals(EL_4, list.get(3));
    assertEquals(EL_5, list.get(4));
    assertEquals(EL_6, list.get(5));

  }

  @Test
  void removeTest() {
    Iterator iterator = list.iterator();

    for (int i = 0; ; i++) {
      if (iterator.hasNext()) {
        iterator.remove();
      } else {
        break;
      }
    }
    assertEquals(0, list.size());
    assertNull(list.get(0));
    assertNull(list.get(1));
    assertNull(list.get(2));
    assertNull(list.get(3));
    assertNull(list.get(4));
    assertNull(list.get(5));
  }

}
