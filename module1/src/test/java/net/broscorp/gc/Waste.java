package net.broscorp.gc;

public class Waste {
  private int index;

  public Waste(int index) {
    this.index = index;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  @Override
  protected void finalize() {
    System.out.println("Waste number = " + index + " is deleted.");
  }
}
