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
}