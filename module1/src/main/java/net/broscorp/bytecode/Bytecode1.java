package net.broscorp.bytecode;

public class Bytecode1 {

  /**
   * Bytecode1 is the class needed to convert to bytecode.
   *
   */

  public static void main(String[] args) {

    int i;
    for (i = 5; i < 15; i++) {
      new Bytecode1().printHello();
    }
    System.out.println(i);
  }

  public void printHello() {
    System.out.println("Hello first bytecode :)");
  }

}
