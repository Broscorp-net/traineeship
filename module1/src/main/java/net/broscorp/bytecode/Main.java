package net.broscorp.bytecode;

/**
 * main class.
 */
public class Main {
  /**
    * printing some message and increase int.
  */
  public static void print() {
    int i;
    for (i = 0; i < 3; i++) {
      i += 1;
    }
    System.out.println("Script is working");
  }

  /*
    main method
   */
  public static void main(String[] args) {
    print();
  }
}
