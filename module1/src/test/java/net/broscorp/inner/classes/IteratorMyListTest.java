package net.broscorp.inner.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IteratorMyListTest {

  MyCoolList<Integer> myList = new MyCoolList<>();

  @Test
  void iteratorHasNextTrue(){
    Iterator<Integer> iterator = myList.iterator();
    myList.add(42);
    Assertions.assertTrue(iterator.hasNext());
  }

  @Test
  void iteratorHasNextFalse(){
    Iterator<Integer> iterator = myList.iterator();
    Assertions.assertFalse(iterator.hasNext());
  }

  @Test
  void iteratorNext(){
    Iterator<Integer> iterator = myList.iterator();
    myList.add(42);
    myList.add(24);
    List<Integer> integerList = new ArrayList<>();
    while(iterator.hasNext()){
      integerList.add(iterator.next());
    }
    Assertions.assertEquals(integerList.get(0), 42);
    Assertions.assertEquals(integerList.get(1), 24);
  }

}
