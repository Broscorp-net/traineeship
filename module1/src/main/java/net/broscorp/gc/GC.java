package net.broscorp.gc;

class GC {

  static GC SAVE;


  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("execute");
    SAVE = this;
  }
}
