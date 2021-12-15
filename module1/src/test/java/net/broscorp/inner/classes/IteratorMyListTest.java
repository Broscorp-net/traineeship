package net.broscorp.inner.classes;

import java.util.Iterator;
import net.broscorp.generics.MyCoolList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IteratorMyListTest {

  MyCoolList<Integer> myList = new MyCoolList<>();

  @Test
  void iteratorHasNextTrue(){
    Iterator<Integer> iterator = myList.iterator();
    Assertions.assertTrue(iterator.hasNext());
  }

}
