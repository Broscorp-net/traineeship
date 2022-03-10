package net.broscorp.gc;

public class DummyReference2 {

  public DummyReference1 ref;

  @Override
  protected void finalize() {
    System.out.println("Good bye obj2");
  }


}
