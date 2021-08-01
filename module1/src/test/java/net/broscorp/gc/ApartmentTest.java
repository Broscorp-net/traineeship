package net.broscorp.gc;

import org.junit.jupiter.api.Test;

class ApartmentTest {

  Room room;
  Apartment apartment;
  AvailableAgain availableAgain;

  @Test
  public void testShouldDeleteOneObjectOnly() {
    for (int i = 0; i < 50; i++) {
      room = new Room(i);
      room = null;
      System.gc();
    }
  }

  @Test
  public void testShouldDeleteTwoObjectsIfParentObjectReferenceIsLost() {
    for (int i = 0; i < 50; i++) {
      apartment = new Apartment(new Room(i));
      apartment = null;
      System.gc();
    }
  }

  @Test
  public void testShouldDeleteTwoObjectsIfChildObjectReferenceIsLost() {
    for (int i = 0; i < 100; i++) {
      apartment = new Apartment(new Room(i));
      room = null;
      System.gc();
    }
  }

  @Test
  void testAvailableInFinalizationBlock() {
    for (int i = 0; i < 50; i++) {
      availableAgain = new AvailableAgain(i);
      availableAgain = null;
      System.gc();
      if (availableAgain != null) {
        System.out.println("Object made available in finalization block");
      } else {
        System.out.println("AvailableAgain object is cleaned up");
      }
    }
  }
}