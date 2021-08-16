package net.broscorp.gc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GarbageCollectionTest {

  @Test
  void garbageCollectionTest() {
    Cars car;
    int count = 1000;
    for (int i = 0; i < count; i++) {
      car = new Cars("car " + i, i);
      car = null;
    }
  }

  @Test
  void restoreObjectBeforeGarbage() throws Throwable {
    CarsRestore car = new CarsRestore("Test Car", 1234);
    System.out.println("New Object " + car + " created");
    final String name = car.getName();
    final int number = car.getNum();
    car = null;
    System.out.println("Reference on Object 'Test Car' is " + car);

    System.gc();
    Thread.sleep(3000);
    System.out.println("Object " + CarsRestore.cr + " is available again.");

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
    Cars car1 = new Cars("Mazda", 1234);
    System.out.println("Object Car1 " + car1 + " created");
    Cars car2 = new Cars("VW", 4567);
    System.out.println("Object Car2 " + car2 + " created");
    car1.other = car2;
    car2.other = car1;
    System.out.println("Car1.other = Car2 " + car1.other);
    System.out.println("Car2.other = Car1 " + car2.other);
  }
}
