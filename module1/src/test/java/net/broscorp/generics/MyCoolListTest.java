package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyCoolListTest {

  private MyCoolList<Integer> intList;

  @BeforeEach
  void setUp() {
    intList = new MyCoolList<>();
  }

  @Test
  void addTest() {
    assertEquals(0, intList.size());

    intList.add(5);
    assertEquals(1,intList.size());
  }

  @Test
  void addTwoObjectsTest() {
    assertEquals(0, intList.size());

    intList.add(10);
    assertEquals(1,intList.size());

    intList.add(50);
    assertEquals(2,intList.size());
  }

  @Test
  void getOneObjectTest() {
    intList.add(5);

    assertEquals(5, intList.get(0));
  }

  @Test
  void getTwoObjectsTest() {
    intList.add(5);

    assertEquals(5, intList.get(0));

    intList.add(10);

    assertEquals(5, intList.get(1));
  }

  @Test
  void removeByIndexTest() {
    intList.add(10);
    intList.add(100);
    intList.add(50);
    intList.add(500);

    assertEquals(50, intList.get(2));

    intList.remove(2);

    assertEquals(500, intList.get(2));
  }

  @Test
  void getSizeTest() {
    assertEquals(0, intList.size());

    intList.add(10);
    intList.add(20);
    intList.add(30);

    assertEquals(3, intList.size());
  }

}
