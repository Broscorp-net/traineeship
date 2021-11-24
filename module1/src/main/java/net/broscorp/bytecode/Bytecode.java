package net.broscorp.bytecode;

public class Bytecode {

  /**.
   * Class to test script
   */
  public static void main(String[] args) {
    int var = 0;
    for (int i = 0; i < 10; i++) {
      var++;
    }
    System.out.println("Var is " + var);
    printHelloInConsole();
    addExtraString();
  }

  private static void addExtraString() {
    System.out.println("EXTRA String for Disassembling");
  }

  private static void printHelloInConsole() {
    System.out.println("Hello in console!");
  }
}
