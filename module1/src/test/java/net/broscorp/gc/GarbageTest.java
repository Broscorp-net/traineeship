package net.broscorp.gc;

import org.junit.jupiter.api.Test;

public class GarbageTest {

  @Test
  void testingGC() {

    Faculty f1 = new Faculty("Physics");
    System.out.println("creating faculty " + f1.getName() + "...");

    Faculty f2 = new Faculty("Biology");
    System.out.println("creating faculty " + f2.getName() + "...");

    Faculty f3 = new Faculty("Math");
    System.out.println("creating faculty " + f3.getName() + "...");

    Faculty f4 = new Faculty("Chemistry");
    System.out.println("creating faculty " + f4.getName() + "...");
    f4 = null;
    Faculty f5 = new Faculty("Logic");
    System.out.println("creating faculty " + f5.getName() + "...");

    Faculty f6 = new Faculty("Science");
    System.out.println("creating faculty " + f6.getName() + "...");
    f6 = null;
    Faculty f7 = new Faculty("Medicine");
    System.out.println("creating faculty " + f7.getName() + "...");

    Faculty f8 = new Faculty("Geography");
    System.out.println("creating faculty " + f8.getName() + "...");
    f8 = null;
    Faculty f9 = new Faculty("Geology");
    System.out.println("creating faculty " + f9.getName() + "...");

    Faculty f10 = new Faculty("Technology");
    System.out.println("creating faculty " + f10.getName() + "...");

    Faculty f11 = new Faculty("Nuclear");
    System.out.println("creating faculty " + f11.getName() + "...");

    Faculty f12 = new Faculty("Space");
    System.out.println("creating faculty " + f12.getName() + "...");
    f12 = null;
    Faculty f13 = new Faculty("Galactic");
    System.out.println("creating faculty " + f13.getName() + "...");

    Faculty f14 = new Faculty("Building");
    System.out.println("creating faculty " + f14.getName() + "...");

    System.gc();
  }

  @Test
  void saveTest() throws InterruptedException {
    GC.SAVE = new GC();

    GC.SAVE = null;
    System.gc();
    Thread.sleep(5000);

    if (GC.SAVE != null) {
      System.out.println("i'm here");
    } else {
      System.out.println("loose");
    }
  }
}
