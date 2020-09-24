package net.broscorp.bytecode;

public class SomeClass {

  /** This javadoc is required by checkstyle. */
  public static void main(String[] args) {
    int number = 0;
    for (int i = 0; i < 100; i++) {
      number++;
    }
    printSomeString();
    System.out.println("Hello, new app!");
  }

  static void printSomeString() {
    System.out.println("Some String!");
  }

  static String newMethod() {
    return "newMethod";
  }
}
