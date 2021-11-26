package net.broscorp.gc;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class MyListTest {

  @BeforeEach
  void setUp() {
    MyList.itemsAdded = 0;
    MyList.timesFinalized = 0;
  }

  @Test
  @Order(1)
  void createALotOfObjects() {
    for (int i = 0; i < 1_000_000; i++) {
      MyList ml = new MyList(i);
    }
    System.out.println("MyList added: " + MyList.itemsAdded);
    System.out.println("MyList finalized: " + MyList.timesFinalized + " times.");
  }

  @SneakyThrows
  @Test
  @Order(2)
  void makeAvailableAgainTest() {
    MyListRevive mlr = new MyListRevive(200);
    mlr = null;
    System.out.println("\nCalling GC");
    System.gc();
    Thread.sleep(5000);
    System.out.println("Trying to access after GC");
    System.out.println("Revived object num is " + mlr.myListRevived.getNum());
  }

  @Test
  @Order(3)
  void referenceOneToAnotherAndBack() {
    MyList ml1 = new MyList(1);
    MyList ml2 = new MyList(2);

    ml1.myList = ml2;
    ml2.myList = ml1;
  }
}