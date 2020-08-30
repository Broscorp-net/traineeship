package net.broscorp.bytecode;

public class Main {

  /**
   * Main class for disassembling testing.
   * @param args - args
   */
   
  public static void main(String[] args) {
    int number = 0;

    while (number < 100) {
      number++;
    }

    someMethod();
    System.out.println("Hello world!" + number);
  }

  public static void someMethod() {
    System.out.println("Hello");
  }
}
