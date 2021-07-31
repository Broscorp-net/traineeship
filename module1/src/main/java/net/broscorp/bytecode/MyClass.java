package net.broscorp.bytecode;

public class MyClass {

  /*public static void multiply(int x){
    System.out.println(x*10);
  }*/

  public static Integer multiply(int x) {
    return x * 10;
  }


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