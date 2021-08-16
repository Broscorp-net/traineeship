package net.broscorp.gc;

public class CarsRestore {

  private String name;
  private int num;
  static CarsRestore cr;

  CarsRestore(String name, int num) {
    this.name = name;
    this.num = num;
  }

  String getName() {
    return name;
  }

  int getNum() {
    return num;
  }

  @Override
  protected void finalize() throws Throwable {
    cr = this;
    System.out.println("Finalization called, but this Object restored in process.");
    super.finalize();
  }

  @Override
  public String toString() {
    return "CarsRestore{"
        + "name = '"
        + name
        + '\''
        + ", number = "
        + num
        + '}';
  }
}
