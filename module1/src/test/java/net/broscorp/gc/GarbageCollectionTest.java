package net.broscorp.gc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GarbageCollectionTest {

  @Test
  void garbageCollectionTest() {
    Cars car;
    int count = 1000000;
    for (int i = 0; i < count; i++) {
      car = new Cars("car " + i, i);
      car = null;
    }
  }

  @Test
  void restoreObjectBeforeGarbage() throws Throwable {
    CarsRestore car = new CarsRestore("Test Car", 1234);
    String name = car.getName();
    int number = car.getNum();
    car = null;
    System.gc();
    Thread.sleep(3000);

    //Object in memory with same name & number
    assertEquals(name, CarsRestore.cr.getName());
    assertEquals(number, CarsRestore.cr.getNum());
  }

  @Test
  void pairRef() throws InterruptedException {
    createObject();
    System.gc();
    Thread.sleep(3000);

  }

  void createObject() {
    Cars car1 = new Cars();
    System.out.println("Object " + car1 + " created");
    Cars car2 = new Cars();
    System.out.println("Object " + car2 + " created");
    car1.other = car2;
    car2.other = car1;
  }
}
