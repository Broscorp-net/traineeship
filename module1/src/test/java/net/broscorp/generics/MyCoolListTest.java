package net.broscorp.generics;

import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  MyCoolList<Integer> myList = new MyCoolList<>(5);


  @Test
  void add() {
    for (int i = 0; i < 10; i++) {
      Random random = new Random();
      int r = random.nextInt(100);
      myList.add(r);
      Assertions.assertEquals(r, myList.get(i));
    }

  }

  @Test
  void get() {
    myList.add(10);
    Integer expected = 10;
    Integer actual = myList.get(0);
    Assertions.assertEquals(expected, actual);

  }

  @Test
  void remove() {
    myList.add(5);
    myList.add(7);
    myList.add(9);
    myList.remove(0);
    Integer expected = 7;
    Integer actual = myList.get(0);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void map() {
    myList.add(20);
    MyCoolList<Integer> map = myList.map(i -> i * 2);
    int expected = myList.get(0) * 2;
    Integer actual = map.get(0);
    Assertions.assertEquals(expected, actual);

  }

  @Test
  void size() {
    int count = 0;
    while (count < 10) {
      count++;
      myList.add(count + 1);
    }
    int expected = count;
    int actual = myList.size();
    Assertions.assertEquals(expected, actual);
  }
}