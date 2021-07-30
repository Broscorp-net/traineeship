package net.broscorp.gc;

class GC {

  static GC SAVE;


  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("executing gc");
    SAVE = this;
  }
}
