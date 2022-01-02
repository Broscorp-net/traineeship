public class MyBytecode {

  public static void foo() {}

  /**
   * Dummy main method to illustrate bytecode
   * @param args
   */
  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {}
    foo();
    System.out.println("Hello bytecode!");
  }
}