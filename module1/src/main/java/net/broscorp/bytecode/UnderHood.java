package net.broscorp.bytecode;

public class UnderHood {


  public static void main(String[] args) {
    // bytecodeV2
    int i1 = Integer.MAX_VALUE;
    long maxValue = Long.MAX_VALUE;
    int incrementToTen = 1;
    for (int i = 0; i <= 10; i++) {
      incrementToTen++;
    }
    String messageFromMethod = getMessageFromMethod();

    System.out.println("getMessageFromMethod => " + messageFromMethod +"\n Max int = "
        + i1 + "\n Max long = " + maxValue
        + i1 + "\n incrementToTen = " + incrementToTen);

    int result = Integer.MAX_VALUE + Integer.MIN_VALUE;
    System.out.println("Result of sum two value =" + result);

  }

  private static String getMessageFromMethod() {
    return "Hello from method that return string";
  }

  // TODO write the script that run UnderHood.java with use next comm:
  //  javac <ClassName.java> - for compile, java
  //  java <ClassName> - for run
  //  javap -c <ClassName> - for show bytecode

}
