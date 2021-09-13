package net.broscorp.gc;

public class CatRef {

  private int id;

  public CatRef() {
  }

  public CatRef(int id) {
    this.id = id;
  }

  @Override
  protected void finalize() throws Throwable {
    CatGcTest.REF = this;

    System.out.println("Cat id " + id + " has been destroyed!");
  }

}
