package net.broscorp.bytecode;

public class Application {

  /**
   * main.
   */
  public static void main(String[] args) {

    int a = 0;
    for (int i = 0; i < 20; i++) {
      a++;
    }
    simpleMethod("Jack");
    //simpleMethodNew(25);
    System.out.println("String to console " + a);
    //System.out.println(a + "New string");
  }

  private static void simpleMethod(String name) {
    System.out.println("Hello " + name);
  }

  private static void simpleMethodNew(int age) {
    System.out.println("Your old = " + age);
  }
}
