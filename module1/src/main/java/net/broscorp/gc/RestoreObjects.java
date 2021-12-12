package net.broscorp.gc;

public class RestoreObjects extends ArrayOfObjects {
  public static RestoreObjects myArrayRestore;

  public RestoreObjects(int id) {
    super(id);
  }

  @Override
  protected void finalize() throws Throwable {

    System.out.println("RestoreObjects in finalize()");
    super.finalize();
    System.out.println("Restoring RestoreObjects");
    myArrayRestore = this;
    System.out.println("RestoreObjects is restored.");
  }
}
