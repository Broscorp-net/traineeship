package net.broscorp.gc;

public class MyListRevive extends MyList {

  public static MyListRevive myListRevived;

  public MyListRevive(int id) {
    super(id);
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("MyListRevived in finalize()");
    super.finalize();
    System.out.println("Restoring MyListRevived");
    myListRevived = this;
    System.out.println("MyListRevived is restored.");
  }
}
