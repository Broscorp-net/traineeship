package net.broscorp.bytecode;

public class Util {

  public static void main(String[] args) {
    int i = 0;
    while (i < 1000) {
      i++;
    }

    simpleMethod();

    System.out.println("Hello World!");
  }

  private static void simpleMethod() {
    int i = 250;
    i |= 2;
  }

}
