package net.broscorp.gc;

public class SecondGC {

  private FirstGC firstGc;

  public void setGc(FirstGC firstGc) {
    this.firstGc = firstGc;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("finalize called on " + this.toString());
    super.finalize();
  }
}
