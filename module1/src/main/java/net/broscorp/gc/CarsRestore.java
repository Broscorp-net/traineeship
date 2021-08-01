package net.broscorp.gc;

public class CarsRestore {

  private String name;
  private int num;
  static CarsRestore cr;

  public CarsRestore(String name, int num) {
    this.name = name;
    this.num = num;
  }

  public String getName() {
    return name;
  }

  public int getNum() {
    return num;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Restore");
    cr = this;
    super.finalize();
  }
}
