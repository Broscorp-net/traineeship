package net.broscorp.gc;



public class ThirdClass {
  long a0;
  GarbageCollection gc;

  /**
  * ThirdClass.
  * @param a0 number
  * @param gc GCT
  */
  public ThirdClass(long a0, GarbageCollection gc) {
    this.a0 = a0;
    this.gc = gc;
    counterText();
  }

  public void counterText() {
    System.out.println("The third object was created " + a0);
  }

  //  @Override
  //  protected void finalize() throws Throwable {
  //    gc.list.add(this);
  //    System.out.println("Method finalize ");
  //    super.finalize();
  //  }
}
