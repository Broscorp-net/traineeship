package net.broscorp.bytecode;

public class SimpleThing {
  public static void main(String[] args) {
    String str = "Hello, world!";

    int i = 0;
    while (i < 100){
      i++;
    }

    message(str);

  }

  public static void message(String s){
    System.out.println(s);
  }

}
