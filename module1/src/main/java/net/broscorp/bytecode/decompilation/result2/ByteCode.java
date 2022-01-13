/* Decompiler 11ms, total 566ms, lines 26 */

package net.broscorp.bytecode.decompilation.result2;

import java.io.PrintStream;

public class ByteCode {
  public static void main(String[] var0) {
    increase();
    print();
  }

  private static void increase() {
    int var0 = 0;

    for (int var1 = 0; var1 < 10; ++var1) {
      PrintStream var10000 = System.out;
      String var10001 = print();
      var10000.println(var10001 + var0++);
    }

  }

  private static String print() {
    return "hello world";
  }
}
