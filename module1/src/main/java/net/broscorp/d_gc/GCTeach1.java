package net.broscorp.d_gc;

public class GCTeach1 {
  public char[] c = new char[2500000];
  public GCTeach gc ;

  @Override
  protected void finalize() {
    System.out.println("GCTeach1 dead");

  }
}

