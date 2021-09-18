package net.broscorp.gc;

public class SpecialCat extends Cat {

  public static SpecialCat spCat;

  public SpecialCat(String name) {
    super(name);
    int[] arr = new int[1000];
  }

  @Override
  protected void finalize() throws Throwable {
    spCat = this;
    finalizeCount++;
    System.out.println();
    System.out.println(getName() + " (SpecialCat) was broken");
    System.out.println("Finalize count: " + finalizeCount);
  }
}
