package net.broscorp.bytecode;

public class SomeClazz {

  /**
   * Main class for disassembling testing.
   * @param args - args
   */

  public static void main(String[] args) {
    //В коментах то что было при первой компиляции
    int someValue = 2; //0
    for (int i = 0; i < 16; i++) { //int i = 0; i < 20; i++
      someValue++;
    }
    System.out.println(multiply(someValue,10)); // (multiply(someValue,3));
    System.out.println(multiply(20,10)); // это новое
    System.out.println("Goodbye Hell"); // "Hello world"
  }

  public static int multiply(int value, int factor) {
    return value * factor;
  }
}
