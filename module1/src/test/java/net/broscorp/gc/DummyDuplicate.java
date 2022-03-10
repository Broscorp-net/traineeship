package net.broscorp.gc;

public class DummyDuplicate {

  private int id;


  public DummyDuplicate(int id) {
    this.id = id;
  }

  @Override
  protected void finalize() {
    GcTest.dummyDuplicate = this;

    System.out.println("Good bye object " + id + " + duplicate " + this);
  }
}
