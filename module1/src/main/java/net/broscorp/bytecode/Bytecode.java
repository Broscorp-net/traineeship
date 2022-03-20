public class Bytecode {

  /**
   * Main method.
   * @param args String[]
   */
  public static void main(String[] args) {
    for (int i = 1; i < 4; i++) {
      printHello();
    }
  }

  static void printHello() {
    System.out.println("Hello World!");
  }

}
