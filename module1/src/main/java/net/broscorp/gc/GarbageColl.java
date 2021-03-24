package net.broscorp.gc;

public class GarbageColl {

  private GarbageColl garbageColl;

  public GarbageColl getGarbageColl() {
    return garbageColl;
  }

  public void setGarbageColl(GarbageColl garbageColl) {
    this.garbageColl = garbageColl;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("finalize   ====  " + garbageColl);
  }
}
