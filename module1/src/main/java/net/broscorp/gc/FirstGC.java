package net.broscorp.gc;

public class FirstGC {

  //  private GC gc = new GC();
  private SecondGC secondGC;

  public void setSecondGC(SecondGC secondGC) {
    this.secondGC = secondGC;
  }

  @Override
  protected void finalize() throws Throwable {
//    gc = this;
    System.out.println("finalize called on " + this.toString());
    super.finalize();
  }

}
