package net.broscorp.bytecode;

public class Bytecode2 {

  /**
   * Bytecode2 is the class needed to convert to bytecode.
   *
   */

  public static void main(String[] args) {

    int i;
    for (i = 10; i <= 20; i++) {
      System.out.println(i);
      i++;
    }
    new Bytecode2().printHello();
  }

  public void printHello() {
    System.out.println("Hello second bytecode :)");
  }

}
