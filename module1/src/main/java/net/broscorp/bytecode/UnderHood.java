package net.broscorp.bytecode;

public class UnderHood {


  public static void main(String[] args) {
    // bytecodeV1
    // int var
    int i1 = Integer.MAX_VALUE;
    // long var
    long maxValue = Long.MAX_VALUE;
    //int var
    int incrementToTen = 1;
    // start loop
    for (int i = 0; i <= 10; i++) {
      incrementToTen++;
    }
    // end loop

    // String var that assign through method
    String messageFromMethod = getMessageFromMethod();

    System.out.println("getMessageFromMethod => " + messageFromMethod +"\n Max int = " + i1 + "\n Max long = " + maxValue);
  }

  private static String getMessageFromMethod() {
    return "Hello from method that return string";
  }

  // TODO write the script that run UnderHood.java with use next comm:
  //  javac <ClassName.java> - for compile, java
  //  java <ClassName> - for run
  //  javap -c <ClassName> - for show bytecode

}
