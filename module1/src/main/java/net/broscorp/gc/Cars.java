package net.broscorp.gc;

public class Cars {

  public Cars other;
  private String name;
  private int num;

  public Cars() {
  }

  public Cars(String name, int num) {
    this.name = name;
    this.num = num;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Object " + this + " removed");
    super.finalize();
  }
}