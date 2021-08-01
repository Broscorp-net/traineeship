package net.broscorp.gc;

public class Room {

  private int livingFloorArea;

  public Room(int livingFloorArea) {
    this.livingFloorArea = livingFloorArea;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Finalization: called on Room Object " + this.livingFloorArea);
  }

  @Override
  public String toString() {
    return "Room object" + livingFloorArea;
  }
}