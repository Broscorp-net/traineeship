package net.broscorp.bytecode;

public class UnderHood {


  public static void main(String[] args) {
    int incrementToTen = 1;
    for (int i = 0; i <= 10; i++) {
      incrementToTen++;
    }
    String messageFromMethod = getMessageFromMethod();
    System.out.println("getMessageFromMethod => " + messageFromMethod);
  }

  private static String getMessageFromMethod() {
    return "Hello from method that return string";
  }

}
