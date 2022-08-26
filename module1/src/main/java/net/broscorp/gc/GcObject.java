package net.broscorp.gc;

public class GcObject {
  private final int id;

  public GcObject(int id) {
    this.id = id;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Obj " + id + " removed");
  }
}
