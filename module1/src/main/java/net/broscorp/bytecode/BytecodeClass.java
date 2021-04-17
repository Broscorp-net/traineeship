package net.broscorp.bytecode;

public class BytecodeClass {

  /**
   * Just a class for a task
   */
  public static void main(String[] args) {
    int increment = 0;
    while (increment < 10) {
      increment++;
    }

    printHello();
  }

  public static void printHello() {
    System.out.println("Hello :)");
  }

  public static void newMethod() {
    int iterator = 0;
    iterator++;
    System.out.println(iterator);
  }
}
