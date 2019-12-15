package net.broscorp.d_gc;

public class GCTeach {

  public char[] c = new char[250000];
  public GCTeach1 gc1;

  @Override
  protected void finalize() {
    System.out.println("Обьект GCTeach dead");
    //пытаемся сделать этот обьект досижимым
    gc1.gc = this;
  }
}
