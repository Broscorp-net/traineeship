package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.function.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCoolListTest {
  MyCoolList myCoolList;

  @BeforeEach
   void init(){
    myCoolList = new MyCoolList();
    myCoolList.add(1);
    myCoolList.add(2);
    myCoolList.add(3);
  }

  @Test
  void add() {
    assertTrue(myCoolList.add(1000));
    assertTrue(myCoolList.add((short)1000));
    assertTrue(myCoolList.add(1213484687l));
    assertFalse(myCoolList.add(100.00));
    assertFalse(myCoolList.add(100.00f));
    assertFalse(myCoolList.add(new DoubleAdder()));
  }

  @Test
  void get() {
    Number expect = 2;
    assertEquals(expect,myCoolList.get(1));
  }

  @Test
  void remove() {
    myCoolList.remove(0);
    assertFalse(myCoolList.contains(1));
  }

  @Test
  void map() {
    Function<Number, Long> convert = x-> x.longValue();
    ArrayList<Long> newList = myCoolList.map(convert);
    for (Long l : newList){
      assertTrue(l instanceof Long);
    }
  }

  @Test
  void size() {
    int expect = 3;
    assertTrue(myCoolList.size() == expect);
  }
}