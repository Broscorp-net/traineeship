package net.broscorp.inner.classes;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InnerClassTest {

  MyCoolList<Integer> myList = new MyCoolList<>();
  Iterator<Integer> iterator = myList.iterator();

  @BeforeEach
  void addValue() {
    myList.add(2);
    myList.add(5);
    myList.add(4);
    myList.add(7);
  }

  @Test
  void hasNextTest() {
    Assertions.assertTrue(iterator.hasNext());
    iterator.next();
    iterator.next();
    iterator.next();
    iterator.next();
    Assertions.assertFalse(iterator.hasNext());
  }

  @Test
  void nextTest() {
    int i = 0;
    while (iterator.hasNext()) {
      Assertions.assertEquals(myList.get(i++), iterator.next());
    }
    NoSuchElementException e = Assertions.assertThrows(NoSuchElementException.class,() -> {
      iterator.next();
    });
  }

}
