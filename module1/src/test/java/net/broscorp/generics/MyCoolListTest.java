package net.broscorp.generics;

import java.util.function.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyCoolListTest {

  @Test
  public void testAddmethodExcpectedListChangeSize() {
    MyCoolList<Integer> list = new MyCoolList<>();

    Assertions.assertTrue(list.size() == 0);

    list.add(1);
    list.add(2);

    int listSizeAfterAdded = list.size();

    Assertions.assertTrue(list.size() == 2);
  }

  @Test
  public void testGetMethodExcpectedSameValue() {
    MyCoolList<Integer> list = new MyCoolList<>();
    list.add(1);
    list.add(2);

    Assertions.assertTrue(list.get(0) == 1);
  }

  @Test
  public void testRemoveMethodExcpectedListChangeSizeAndRemoveObject() {
    MyCoolList<Integer> list = new MyCoolList<>();
    list.add(1);
    list.add(2);

    Assertions.assertTrue(list.size() == 2);

    list.remove(0);
    Assertions.assertTrue(list.size() == 1);
    Assertions.assertTrue(list.get(0) == 2);
  }

  @Test
  public void testSizeMethodExcpectedCurrectListSize() {
    MyCoolList<Integer> list = new MyCoolList<>();

    Assertions.assertTrue(list.size() == 0);

    list.add(1);
    list.add(2);

    Assertions.assertTrue(list.size() == 2);
  }

  @Test
  public void testMapMethodExcpectedNewList() {
    MyCoolList<Integer> list = new MyCoolList<>();
    list.add(1);
    list.add(2);

    Function<Integer, Double> function = Integer::doubleValue;

    MyCoolList<Double> mapList = list.map(function);

    Assertions.assertTrue(mapList.get(0) instanceof Double);
  }
}
