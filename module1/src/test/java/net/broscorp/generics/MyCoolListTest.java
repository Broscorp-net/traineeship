package net.broscorp.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyCoolListTest {

  @Test
  public void addingElementsToTheList() {
    MyCoolList<Integer> myCoolListInt = new MyCoolList<>();
    myCoolListInt.add(1);
    myCoolListInt.add(5);
    myCoolListInt.add(10);

    Assertions.assertTrue(myCoolListInt.size() == 3);

    MyCoolList<Double> myCoolListDouble = new MyCoolList<>();
    myCoolListDouble.add(5.0);
    myCoolListDouble.add(10.0);
    myCoolListDouble.add(8.0);

    Assertions.assertTrue(myCoolListDouble.size() == 3);
  }

  @Test
  public void removingElementsFromTheList() {
    MyCoolList<Integer> myCoolListInt = new MyCoolList<>();
    myCoolListInt.add(1);
    myCoolListInt.add(5);
    myCoolListInt.add(10);
    myCoolListInt.remove(2);

    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myCoolListInt.get(2));

    MyCoolList<Double> myCoolListDouble = new MyCoolList<>();
    myCoolListDouble.add(5.0);
    myCoolListDouble.add(10.0);
    myCoolListDouble.add(8.0);
    myCoolListDouble.remove(1);

    Assertions.assertTrue(myCoolListDouble.get(1) == 8.0);
  }


}
