package broscorp.gc;

import java.text.DecimalFormat;
import net.broscorp.gc.FirstGC;
import net.broscorp.gc.SecondGC;
import org.junit.jupiter.api.Test;

public class GCTest {

  Runtime runtime = Runtime.getRuntime();
  DecimalFormat df = new DecimalFormat("#,###,###,###.##");

// закомментировал т.к. Github не переваривает
/*  @Test
  void generateObjects() {
    for (int i = 0; i < 10_000_000; i++) {
      FirstGC firstGc = new FirstGC();
    }
  }*/

  @Test
  void tryCallGarbageCollector() throws InterruptedException {
    System.out.println("Free memory before Garbage Collector "
        + df.format((runtime.maxMemory() - runtime.totalMemory() - runtime.freeMemory())));
    System.gc();
    //  TimeUnit.SECONDS.sleep(5);
    System.out.println("Free memory after Garbage Collector "
        + df.format((runtime.maxMemory() - runtime.totalMemory() - runtime.freeMemory())));
    //все попытки "посчитать" освобожденную память кончились ничем(
  }

  @Test
  void generateCrossReferencesObjects() {
    for (int i = 0; i < 10_000_000; i++) {
      FirstGC firstGc = new FirstGC();
      SecondGC secondGC = new SecondGC();
      firstGc.setSecondGC(secondGC);
      secondGC.setGc(firstGc);
    }
  }

}
