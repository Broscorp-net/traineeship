package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertTrue;

import net.broscorp.generics.MyCoolList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyIterableCoolListTest {

  MyCoolList<Number> myCoolList;

  @BeforeEach
  void init() {
    myCoolList = new MyCoolList();
    myCoolList.add(1);
    myCoolList.add(2);
    myCoolList.add(3);
  }

  @Test
  void iterate() {
    int expect = myCoolList.size();
    int rezult = 0;
    for (Number number : myCoolList) {
      rezult++;
    }
    assertTrue(expect == rezult);
  }

}
