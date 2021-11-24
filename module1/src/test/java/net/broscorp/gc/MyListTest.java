package net.broscorp.gc;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

class MyListTest {

  @Test
  void createALotOfObjects() {
    for (int i = 0; i < 1_000_000; i++) {
      MyList ml = new MyList(i);
    }
  }

  @SneakyThrows
  @Test
  void makeAvailableAgainTest() {
    MyListRevive mlr = new MyListRevive(200);
    mlr = null;
    System.out.println("Calling GC");
    System.gc();
    Thread.sleep(5000);
    System.out.println("Trying to access after GC");
    System.out.println("Revived object num is " + mlr.myListRevived.getNum());
  }

  @SneakyThrows
  @Test
  void referenceOneToAnotherAndBack() {
    MyList ml1 = new MyList(1);
    MyList ml2 = new MyList(2);

    ml1.myList = ml2;
    ml2.myList = ml1;

    System.gc();
  }
}