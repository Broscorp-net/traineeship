package net.broscorp.gc;

public class Cat {

  private int id;

  public Cat() {
  }

  public Cat(int id) {
    this.id = id;
  }

  @Override
  protected void finalize() throws Throwable {

    System.out.println("Cat id " + id + " has been destroyed!");
  }

}
