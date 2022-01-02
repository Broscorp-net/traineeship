package net.broscorp.gc;

public class MyClass {

  protected void finalize() throws Throwable {
    try {
      System.out.println("inside finalize() at " + java.time.LocalTime.now());
    } catch (Throwable e) {
      throw e;
    } finally {
      super.finalize();
    }
  }
}