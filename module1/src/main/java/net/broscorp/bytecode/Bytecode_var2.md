Compiled from "TestApp.java"
public class net.broscorp.bytecode.TestApp {
  public net.broscorp.bytecode.TestApp();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: ldc           #2                  // String qwerty
       2: astore_1
       3: new           #3                  // class java/util/ArrayList
       6: dup
       7: invokespecial #4                  // Method java/util/ArrayList."<init>":()V
      10: astore_2
      11: iconst_0
      12: istore_3
      13: iload_3
      14: iconst_5
      15: if_icmpge     24
      18: iinc          3, 1
      21: goto          13
      24: invokestatic  #5                  // Method helloMethod:()V
      27: return
}
