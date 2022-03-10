/*package net.broscorp.bytecode;

public class Bytecode {

  public static void main(String[] args) {
    int a = 5;
    for (int i = 0; i < 5; i++) {
      a++;
    }
    a = Math.abs(3);
    System.out.println("Hello World!");
  }

}*/

package net.broscorp.bytecode;

public class Bytecode {

  /**
   * This is my Bytecode test solution. Commented section in the top is the First usecase
   * Uncommented section is the second usecase Analytics at the bottom comment
   */
  public static void main(String[] args) {
    int a = 5;
    while (a > 1) {
      a--;
    }
    a = Math.abs(5);
    System.out.println("WITCHCRAFT!");
  }
}

/*
My thoughts on the decompilation results:
1) for() loop had more operations (one more increment, more memory allocation)
2) changing the method parameter had no real effect
3) Same thing with String, except ofc having a different string
 */