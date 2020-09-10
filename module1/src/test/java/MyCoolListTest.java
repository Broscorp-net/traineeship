package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  private MyCoolList<Integer> myCoolList;
  private int list_size;
  private Function<Integer, Short> function = Integer::shortValue;

  @BeforeEach
  public void start() {
    myCoolList = new MyCoolList<>();
    list_size = 10;

    for (int i = 0; i < list_size; i++) {
      myCoolList.add(i);
    }
    print();
  }

  @Test
  public void addMethodTest() {
    int number = 10;
    myCoolList.add(number);
    list_size++;
    print();
    assertTrue(myCoolList.get(list_size - 1) == number);
  }

  @Test
  public void getMethodTest() {
    for (int i = 0; i < myCoolList.size(); i++) {
      assertTrue(i == myCoolList.get(i));
    }
  }

  @Test
  public void removeMethodTest() {
    myCoolList.remove(list_size - 1);
    list_size--;
    print();
    assertTrue(myCoolList.size() == list_size);
  }

  @Test
  public void mapMethodTest() {
    MyCoolList<Number> list = myCoolList.map(function);
    assertTrue(list.get(0) instanceof Short);
  }

  @Test
  public void sizeMethodTest() {
    assertTrue(list_size == myCoolList.size());
  }

  public void print() {
    for (int i = 0; i < myCoolList.size(); i++) {
      System.out.print(myCoolList.get(i) + " ");
    }
    System.out.println();
  }
}