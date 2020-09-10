package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyIterableCoolListTest {

  @Test
  void checkIterationIsPossible() {
    MyIterableCoolList<Number> myCoolList = new MyIterableCoolList<>();
    myCoolList.add(1);
    myCoolList.add(2);
    myCoolList.add(3);

    int expect = myCoolList.size();
    int result = 0;
    for (Number number : myCoolList) {
      result++;
    }
    assertEquals(result, expect);
  }

  @Test
  void checkCorrectOrderCopy() {
    MyIterableCoolList<Number> myCoolList = new MyIterableCoolList<>();
    myCoolList.add(10);
    myCoolList.add(20d);
    myCoolList.add(30L);
    MyIterableCoolList<Number> myCoolListCopy = new MyIterableCoolList<>();
    for (Number number : myCoolList) {
      myCoolListCopy.add(number);
    }
    // так можно?
    for (int i = 0; i < myCoolList.size(); i++) {
      assertEquals(myCoolList.get(i), myCoolListCopy.get(i));
    }
  }
}