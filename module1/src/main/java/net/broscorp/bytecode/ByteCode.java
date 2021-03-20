package net.broscorp.bytecode;

/**
 * Class for check bytecode.
 */
public class ByteCode {
  /**
   * main method for run app.
   * @param args String[]
   */
  public static void main(String[] args) {
    int a = 0;
    for (int i = 0; i < 10; i++) {
      a++;
    }
    print("Hello");
  }

  public static void print(String someWord) {
    System.out.println(someWord);
  }
}
