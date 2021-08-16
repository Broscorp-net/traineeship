package net.broscorp.gc;

public class Cars {

  Cars other;
  private String name;
  private int num;

  public Cars() {
  }

  Cars(String name, int num) {
    this.name = name;
    this.num = num;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Finalization called. Object "
        + this
        + " removed");
    super.finalize();
  }

  @Override
  public String toString() {
    return "name = '" + name
        + '\''
        + ", number = " + num;
  }
}