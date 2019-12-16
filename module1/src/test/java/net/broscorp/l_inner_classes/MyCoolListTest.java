package net.broscorp.l_inner_classes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  @Test
  void iteratorCheckout() {
    MyCoolList<Integer> myList = new MyCoolList<>();
    myList.add(1);
    myList.add(2);
    myList.add(3);
    Iterator<Integer> myIterator = myList.iterator();

    int count = 0;

    while (myIterator.hasNext()) {
      Integer element = myIterator.next();
      count++;
      if (count == 1) {
        assertEquals(element, 1);
      } else if (count == 2) {
        assertEquals(element, 2);
      } else if (count == 3) {
        assertEquals(element, 3);
      }

    }
    assertEquals(count, 3);
  }

}
