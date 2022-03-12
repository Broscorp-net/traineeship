package net.broscorp.bytecode;

/**
 * Dummy class to demonstrate bytecode processes.
 */
public class ByteCodeExample {
  /**
   * Main class to launch something, I don't know.
   * @param args - empty args, nothing new.
   */
  public static void main(String[] args) {
    int dummy = 0;

    for (int i = 0; i < 10; i++) {
      dummy++;
    }

    printHelloAndIntValue(dummy);
  }

  private static void printHelloAndIntValue(int i) {
    System.out.println("Hello, the value is " + i);
  }
}
