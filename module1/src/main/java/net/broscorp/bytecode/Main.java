package net.broscorp.bytecode;

/** main. */
public class Main {

  public static int x;

  public static void hello() {
    System.out.println("Hello");
  }

  /**javadoc.
   * @param args - string.
   * */
  public static void main(String[] args) {

    for (int i = 0; i < 5; i++) {
      System.out.println(x + i);
    }

    Main.hello();
  }
}
