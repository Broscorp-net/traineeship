package net.broscorp.gc;

public class WasteReference {
  private int index;
  private Waste waste;

  public WasteReference(int index, Waste waste) {
    this.index = index;
    this.waste = waste;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public void setWaste(Waste waste) {
    this.waste = waste;
  }

  public Waste getWaste() {
    return waste;
  }

  @Override
  protected void finalize() {
    System.out.println("WasteReference number = " + index + " is deleted.");
  }

}
