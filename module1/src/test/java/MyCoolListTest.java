package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  private MyCoolList<Integer> myCoolList;
  private int listSize;

  @BeforeEach
  public void start() {
    myCoolList = new MyCoolList<>();
    listSize = 10;

    for (int i = 0; i < listSize; i++) {
      myCoolList.add(i);
    }
    print();
  }

  @Test
  public void addMethodTest() {
    int number = 10;
    myCoolList.add(number);
    listSize++;
    print();
    assertTrue(myCoolList.get(listSize - 1) == number);
  }

  @Test
  public void getMethodTest() {
    for (int i = 0; i < myCoolList.size(); i++) {
      assertTrue(i == myCoolList.get(i));
    }
  }

  @Test
  public void removeMethodTest() {
    myCoolList.remove(listSize - 1);
    listSize--;
    print();
    assertTrue(myCoolList.size() == listSize);
  }

  @Test
  public void mapMethodTest() {
    Function<Integer, Double> function = Integer::doubleValue;
    MyCoolList<Double> list = myCoolList.map(function);
    assertTrue(list.get(0) instanceof Double);
  }

  @Test
  public void sizeMethodTest() {
    assertTrue(listSize == myCoolList.size());
  }

  public void print() {
    for (int i = 0; i < myCoolList.size(); i++) {
      System.out.print(myCoolList.get(i) + " ");
    }
    System.out.println();
  }
}