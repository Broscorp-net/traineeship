package net.broscorp.gc;

public class Dummy {

  private int id;

  public Dummy(int id) {
    this.id = id;
  }

  @Override
  protected void finalize() {
    System.out.println("Good bye object " + id);
  }
}
