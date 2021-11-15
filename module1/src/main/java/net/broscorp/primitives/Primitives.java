package net.broscorp.primitives;

public class Primitives {


  public byte count(int a) {
    byte b = 0;
    for (int i = 0; i < a; i++) {
      ++b;
    }
    return b;
  }

}
