package net.broscorp.bytecode;

/**
 * Sample class used for a disassembling test. Commented code show the difference in code between
 * decompiled outputs.
 */
public class MyClass {

  /*public static void multiply(int x){
    System.out.println(x*10);
  }*/

  public static Integer multiply(int x) {
    return x * 10;
  }

  /**
   * Main method.
   *
   * @param args - Command line params.
   */
  public static void main(String[] args) {
    Integer variable = 0;

    for (int i = 0; i < 10; i++) {
      variable++;
    }

    //multiply(variable);
    System.out.println(multiply(variable));

    System.out.println("Hi, may i sit here?");

  }

}