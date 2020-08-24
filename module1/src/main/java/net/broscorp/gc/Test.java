package net.broscorp.gc;

import java.io.IOException;

public class Test {

  /**
   * Класс в котором проводятся эксперименты с GC.
   */
  public static void main(String[] args) {
    GcTest test = new GcTest("object");
    //test.largeNumberOfObjects();
    test.twoLinksToOneObject();

    //new Immortal();
    //System.gc();
    //sleep(1_000);
    //System.gc();
    //prompt("Press any key...");
  }

  private static void prompt(String msg) {
    try {
      System.out.println(msg);
      System.in.read();
    } catch (IOException io) {
      System.out.println("some trouble");
    }
  }

  private static void sleep(long duration) {
    try {
      Thread.sleep(duration);
    } catch (InterruptedException ie) {
      System.out.println("some trouble");
    }
  }

}
