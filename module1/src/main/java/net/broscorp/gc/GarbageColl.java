package net.broscorp.gc;

public class GarbageColl {

  public static void main(String[] args) {
    for (int i = 0; i < 50000; i++) {
      System.out.println(i);
      GarbageColl nullObj = new GarbageColl();
      GarbageColl first = new GarbageColl();
      GarbageColl second = new GarbageColl();
      nullObj.setGarbageColl(null);
//      first.setGarbageColl(second);
//      second.setGarbageColl(first);
    }
  }

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
