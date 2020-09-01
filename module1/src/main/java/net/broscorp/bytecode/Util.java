package net.broscorp.bytecode;

public class Util {

  /**
   * Entry point.
   * @param args Command-line arguments
   */
  public static void main(String[] args) {
    int i = 0;
    while (i < 1000) {
      i++;
    }

    simpleMethod(100);

    System.out.println("Hello World!");
  }

  private static void simpleMethod(int n) {
    int i = 250;
    i <<= 2;
    i += n;
  }

}
