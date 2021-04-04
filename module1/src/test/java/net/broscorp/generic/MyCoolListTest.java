package net.broscorp.generic;

import net.broscorp.generics.MyCoolList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyCoolListTest {

  private MyCoolList<Double> myCoolList;
  private final Double exampleDouble = 5.2;
  private final double start = 0;
  private final double last = 3;
  private final double step = 0.5;

  @BeforeEach
  void init() {
    myCoolList = new MyCoolList<>();
    for (double i = start; i <= last; i += step) {
      myCoolList.add(i);
    }
  }

  @Test
  void addMyCoolListTest() {
    myCoolList.add(exampleDouble);
    Assertions.assertEquals(exampleDouble, myCoolList.get(myCoolList.size() - 1));
  }

  @Test
  void getMyCoolListTest() {
    int j = 0;
    for (double i = start; i <= last; i += step) {
      Assertions.assertEquals(i, myCoolList.get(j));
      j++;
    }
    Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> myCoolList.get(-1));
    Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
        () -> myCoolList.get(myCoolList.size() + 1));
  }

  @Test
  void removeMyCoolListTest() {
    myCoolList.add(exampleDouble);
    Assertions.assertEquals(exampleDouble, myCoolList.remove(myCoolList.size() - 1));
  }

  @Test
  void mapMyCoolListTest() {
    Assertions.assertTrue(myCoolList.map(Double::intValue).get(0) instanceof Integer);
  }

  @Test
  void checkSizeMyCoolListTest() {
    int size = myCoolList.size();
    myCoolList.add(1.1);
    myCoolList.add(2.1);
    Assertions.assertEquals(size + 2, myCoolList.size());
  }
}