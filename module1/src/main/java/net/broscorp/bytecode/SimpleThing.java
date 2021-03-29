package net.broscorp.bytecode;

public class SimpleThing {

  /**
   * To display a message.
   * @param args has no parameters
   */
  public static void main(String[] args) {
    String str = "Hello, world!";

    int i = 0;
    while (i < 100) {
      i++;
    }
    message(str);
    int j = 0;
    while (j < 100) {
      j++;
    }

    System.out.println("Goodbye!");
  }

  public static void message(String s) {
    System.out.println(s);
  }

}
