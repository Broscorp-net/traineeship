package net.broscorp.bytecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
  static List<Integer> list = new ArrayList<Integer>();

  /**
   * Entry point.
   * @param args arguments
   */

  @SuppressWarnings("ok")
  public static void main(String[] args) {
    int num = 5;
    Solution solution = new Solution();

    /* Increment in a loop. */
    for (int i = 0; i < 5; i++) {
      num++;
    }

    /* Invocation of a method. */
    solution.method();

    /* Greetings to console. */
    System.out.println("Greetings");
  }

  @Deprecated
  public int method() {
    return new Random().nextInt(11);
  }

  /*
  * I see in decompiled file for this case [decompiled1.txt]
  * that default constructor was added automatically. Also
  * variable names were changed for var1, var2, ... var[n].
  * But it is affected only local variables.
  * Instance variable name was not changed. We can see it
  * in [decompiled2.txt] ==> int num
  *
  * I have also noticed that returned value by the method
  * was taken to the brackets after decompile.
  *
  * Simple comments and javadoc deleted after decompiling.
  *
  * Generic type was erased from the ArrayList ==> ArrayList(),
  * but still there near the variable of List type ==> List<Integer>.
  *
  * Annotation with RetentionPolicy.RUNTIME was still there after
  * decompile [@Deprecated]. On the other hand annotation
  * [@SuppressWarnings] was deleted as far as it has
  * RetentionPolicy.Source.
  */
}

