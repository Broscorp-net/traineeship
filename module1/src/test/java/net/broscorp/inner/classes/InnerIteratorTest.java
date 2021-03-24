package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InnerIteratorTest {
  private MyCoolList<Integer> list = new MyCoolList<>();
  private Iterator<Integer> iterator = list.getIterator();

  @BeforeEach
  void setUp() {
    list.add(1);
    list.add(2);
    list.add(3);
  }

  @Test
  void iteratorShouldReturnInRightOrder() {
    MyCoolList<Integer> coolList = new MyCoolList<>();
    while (iterator.hasNext()) {
      coolList.add(iterator.next());
    }

    for (int i = 0; i < list.size(); i++) {
      assertEquals(coolList.get(i), list.get(i));
    }
  }
}
