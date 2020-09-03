package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyIterableCoolListTest {

  MyIterableCoolList<Number> myCoolList;

  @BeforeEach
  void init() {
    myCoolList = new MyIterableCoolList<>();
    myCoolList.add(1);
    myCoolList.add(2);
    myCoolList.add(3);
  }

  @Test
  void checkIterationIsPossible() {
    int expect = myCoolList.size();
    int rezult = 0;
    for (Number number : myCoolList) {
      rezult++;
    }
    assertTrue(expect == rezult);
  }
}