package net.broscorp.gc;

public class RestorationWaste {
  private int index;

  public RestorationWaste(int index) {
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
    TestGC.restorationWaste = this;
    System.out.println("RestorationWaste number = " + index + " is not deleted.");
  }
}
