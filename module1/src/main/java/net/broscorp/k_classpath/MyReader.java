package net.broscorp.k_classpath;


public class MyReader {

  public void readFromConsole(Integer i) {
    System.out.println(i);
  }

  public static void main(String[] args) {
    new MyReader().readFromConsole(new MyWriter().writingToConsole());
  }
}
