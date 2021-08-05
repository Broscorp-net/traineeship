package net.broscorp.gc;

import org.junit.jupiter.api.Test;

public class GlassTest {

  @Test
  public void gcGlassTest() {
    for (int i = 0; i < 100_000; i++) {
      Glass glass = new Glass(i);
    }
  }

  @Test
  public void gcGlassGluedTest() {
    GlassGlued glassGlued = new GlassGlued(100500);

    try {
      System.out.println("Trying to access ");
      System.out.println(glassGlued.getId());

      System.out.println("Finalizing object");
      glassGlued = null;

      System.out.println("Running gc");
      System.gc();

      Thread.sleep(1);

    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } finally {
      System.out.println("Trying to access again");
      System.out.println(GlassGlued.reserveGlass.getId());
    }

  }

  @Test
  public void gcWildRefGlassTest() {
    ((Runnable) () -> {
      GlassReference glass1 = new GlassReference(1);
      GlassReference glass2 = new GlassReference(2);

      glass1.glass = glass2;
      glass2.glass = glass1;
    }).run();

    System.gc();

  }


}
