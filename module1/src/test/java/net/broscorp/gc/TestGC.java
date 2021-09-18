package net.broscorp.gc;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class TestGC {
  ArrayList<Cat> catsList;

  @Test
  void testCallGC() throws Throwable {
    catsList = new ArrayList<>();

    long start = System.currentTimeMillis();
    System.out.println("start : " + start);

    int i = 0;
    while (i < 2_000_000) {
      catsList.add(new Cat("Cat" + i));

      if (i == 60) {
        catsList.remove(20);
      }

      if (i == 100) {
        catsList.get(80).next = catsList.get(81);
        catsList.get(81).prev = catsList.get(80);
        catsList.set(80, null);
        catsList.set(81, null);
      }

      if (i == 200) {
        catsList.set(0, new SpecialCat("Cat" + i));
      }

      if (i == 300) {
        catsList.remove(0);
      }

      i++;
    }

    long end = System.currentTimeMillis();
    System.out.println();
    System.out.println("end : " + end);
    System.out.println("end - start : " + (end - start));

    Thread.sleep(3000);
    assertNotEquals(null, SpecialCat.spCat);
  }
}

