package net.broscorp.bytecode;

public class SomeClass {

  /**
   * main - method runs code executing.
   *
   * @param args command line parameters
   */
  public static void main(String[] args) {

    //    VARIANT 1:
    //    int i = 0;
    //    do {
    //      System.out.println("Hello from i = " + i);
    //      i = increment(i);
    //    } while (i < 10);

    //    VARIANT 2:
    //    for (int i = 0; i < 10; i++) {
    //      System.out.println("Hello from i = " + increment(i - 1));
    //    }

    //    VARIANT 3:
    int i = 0;
    while (i < 10) {
      System.out.println("Hello from i = " + i);
      i = increment(i);
    }
  }

  //  VARIANT 1:
  //  private static int increment(int i) {
  //    return ++i;
  //  }

  //  VARIANT 2:
  //  public static int increment(int i) {
  //    return ++i;
  //  }

  //    VARIANT 3:
  public static int increment(int i) {
    return i + 1;
  }
}
