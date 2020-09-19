package net.broscorp.gc;

public class ObjectForGarbaCollector {
  private ObjectForGarbaCollector gc;

  public ObjectForGarbaCollector getGc() {
    return gc;
  }

  public void setGc(ObjectForGarbaCollector gc) {
    this.gc = gc;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("finalize called on " + this.toString());
    super.finalize();
  }
}
