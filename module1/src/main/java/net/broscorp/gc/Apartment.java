package net.broscorp.gc;

public class Apartment {

  Room room;

  public Apartment(Room room) {
    this.room = room;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Finalization: called on Apartment Object " + this.room.toString());
  }
}




