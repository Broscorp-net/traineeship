package net.broscorp.bytecode;

public class Main {

  /** Main class for a bytecode disassembler.
   *
   * @param args Args of main method
   */
  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      System.out.println(i);
    }

    print("Hi");
    print("My name is Grigory");

    System.out.println("Hello World!");
  }

  public static void print(String text) {
    System.out.println(text);
  }
}
