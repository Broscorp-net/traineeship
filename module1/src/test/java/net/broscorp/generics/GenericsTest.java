package net.broscorp.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GenericsTest {

  MyCoolList<Integer> myList = new MyCoolList<>();

  @BeforeEach
  void addValue() {
    myList.add(2);
    myList.add(5);
    myList.add(4);
    myList.add(7);
  }

  @Test
  void getTest() {
    Assertions.assertEquals(5, myList.get(1));
  }

  @Test
  void sizeTest() {
    Assertions.assertEquals(4, myList.size());
  }

  @Test
  void removeTest() {
    Assertions.assertEquals(4, myList.remove(2));
    Assertions.assertEquals(3, myList.size());
  }

  @Test
  void mapTest() {
    MyCoolList myListNew = myList.map(m -> m + 5);
    Assertions.assertEquals(7, myListNew.get(0));
  }

}
