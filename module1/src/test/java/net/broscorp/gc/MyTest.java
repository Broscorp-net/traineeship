package net.broscorp.gc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyTest {

  @Test
  void test() {
    for (int i = 0; i < 100; i++) {
      MyClass c = new MyClass();
    }
  }
}