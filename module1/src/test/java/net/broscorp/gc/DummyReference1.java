package net.broscorp.gc;

public class DummyReference1 {

  public DummyReference2 ref;

  @Override
  protected void finalize() {
    System.out.println("Good bye obj1");
  }

}
