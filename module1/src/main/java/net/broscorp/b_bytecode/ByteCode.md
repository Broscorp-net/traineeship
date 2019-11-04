 #1 Byte Code


Compiled from "MyClass.java"
public class MyClass {
  public MyClass();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: iconst_0
       1: istore_1
       2: iload_1
       3: bipush        12
       5: if_icmpgt     14
       8: iinc          1, 1
      11: goto          2
      14: invokestatic  #2                  // Method getNumber:()I
      17: istore_2
      18: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
      21: ldc           #4                  // String Byte code workflow
      23: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      26: return

  public static int getNumber();
    Code:
       0: iconst_5
       1: ireturn
}



 #2 Byte Code (ADD JENERIC TO CLASS)


Compiled from "MyClass.java"
public class MyClass<Integer> {
  public MyClass();
    Code:
       0: aload_0

       1: invokespecial #1      // Method java/lang/Object."<init>":()V <- JENERIC initialization
      
 4: return

public static void main(java.lang.String[]);
    Code:
       0: iconst_0
       1: istore_1
       2: iload_1
       3: bipush        12
       5: if_icmpgt     14
       8: iinc          1, 1
      11: goto          2
      14: invokestatic  #2                  // Method getNumber:()I
      17: istore_2
      18: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
      21: ldc           #4                  // String Byte code workflow
      23: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      26: return

  public static int getNumber();
    Code:
       0: iconst_5
       1: ireturn
}




#3 Byte Code(add fields to class with different access modifiers; add        parametrized ArrayList) 


Compiled from "MyClass.java"
public class MyClass {
  protected java.lang.String password;
                                           <- PRIVATE FILD IS HIDED
  public java.lang.Float someFloat;

  public MyClass();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: iconst_0
       1: istore_1
       2: new           #2                  // class java/util/ArrayList <-ARRAYLIST
                                                 INITIALIZE ARRAYLIST AS JENERIC
       5: dup
       6: invokespecial #3                  // Method java/util/ArrayList."<init>":()V
       9: astore_2
      10: invokestatic  #4                  // Method getNumber:()I
      13: istore_3
      14: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
      17: ldc           #6                  // String Byte code workflow
      19: invokevirtual #7                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      22: return

  public static int getNumber();
    Code:
       0: iconst_5
       1: ireturn
}
 

