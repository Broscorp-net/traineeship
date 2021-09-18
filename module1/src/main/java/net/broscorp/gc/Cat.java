package net.broscorp.gc;

public class Cat {
  public static int finalizeCount;

  String name;
  public Cat next;
  public Cat prev;

  public Cat(String name) {
    this.name = name;
    int[] arr = new int[1000];
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  protected void finalize() throws Throwable {
    finalizeCount++;
    System.out.println();
    System.out.println(getName() + " will be delete GC");
    System.out.println("Finalize count: " + finalizeCount);
  }
}

