package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import net.broscorp.generics.MyCoolList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InnerClassesTest {

  MyCoolList<Integer> coolList = new MyCoolList<>();
  Iterator<Integer> itr = coolList.iterator();

  @BeforeEach
  public void setUp() {
    for (int i = 0; i < 10; i++) {
      coolList.add(i);
    }
  }


  @Test
  public void hasNext() {
    for (int i = 0; i < 10; i++) {
      assertTrue(itr.hasNext());
      itr.next();
    }
    assertFalse(itr.hasNext());
  }

  @Test
  public void next() {
    for (int i = 0; i < 10; i++) {
      assertEquals(i, itr.next());
    }
  }

  @Test
  public void nextCheckException() {
    for (int i = 0; i < 10; i++) {
      itr.next();
    }
    assertThrows(NoSuchElementException.class, () -> itr.next());
  }

  @Test
  public void remove() {
    itr.remove();
    assertEquals(9, coolList.size());
  }
}
