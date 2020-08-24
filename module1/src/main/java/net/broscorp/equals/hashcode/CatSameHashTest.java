package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatSameHashTest {

  List<Cat> cats;
  Random random;

  @BeforeEach
  void setUp() {
    random = new Random();
    cats = new ArrayList<>();
    String name = "Cat";

    for (int i = 0; i < 500000; i++) {
      cats.add(new Cat(i, random.nextInt(), name + i));
    }
  }

  @Test
  void sameHashcodeTest() {
    Map<Integer, List<Cat>> catHash = cats.stream()
            .collect(Collectors.groupingBy(Cat::hashCode));
    Set<Map.Entry<Integer, List<Cat>>> entryCat = catHash.entrySet();

    entryCat.forEach(cat -> {
      List<Cat> catEntry = cat.getValue();
      for (int i = 0; i < catEntry.size() - 1; i++) {
        System.out.println("Вот объект " + catEntry.get(i)
                + ", вот объект " + catEntry.get(i + 1)
                + ", они разные, но их хеш совпадает");
        assertNotEquals(catEntry.get(i + 1), catEntry.get(i));
        assertEquals(catEntry.get(i + 1).hashCode(), catEntry.get(i).hashCode());
      }
    });
  }
}