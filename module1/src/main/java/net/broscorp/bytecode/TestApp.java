package net.broscorp.bytecode;

public class TestApp {

  /**
   * Main method
   * @param args
   * increment param i and use method
   */
  public static void main(String[] args) {
    //1
    int i = 0;
    while (i < 5) {
      i++;
    }

    //2 and 3
    helloMethod();
  }

  private static void helloMethod() {
    System.out.println("Hello, world!!!");
  }
}
