package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CatTest {

  static List<Cat> cats = new ArrayList<>();

  /**
   * Methods with this annotation are run before each test.
   * Let's add some objects to our list
   */
  @BeforeAll
  public static void fillingList() {
    cats = Stream.of(
        new Cat("Tom", "British", 4),
        new Cat("Tom", "British", 9),
        new Cat("Luci", "American", 5),
        new Cat("Angel", "Russian", 2))
        .collect(Collectors.toList());
  }

  @Test
  public void equalsHashTest() {
    assertEquals(cats.get(0).hashCode(), cats.get(1).hashCode());
  }

  @Test
  public void notEqualsHashTest() {
    assertNotEquals(cats.get(0).hashCode(), cats.get(2).hashCode());
  }

  @Test
  public void equalsTest() {
    assertFalse(cats.get(0).equals(cats.get(1)));
  }

  @Test
  public void notEqualsTest() {
    assertFalse(cats.get(0).equals(cats.get(2)));
  }

  @Test
  public void findTheSameObjectsForEqualsHashCodes() {
    Cat first = null;
    Cat second = null;

    for (int i = 0; i < cats.size() - 1; i++) {
      first = cats.get(i);
      second = cats.get(i + 1);
      if (first.hashCode() == second.hashCode() && !first.equals(second)) {
        System.out.println("Вот объект " + first + ", вот объект " + second
            + ", они разные, но их хеш совпадает");
        break;
      }
    }
    assertEquals(first.hashCode(), second.hashCode());
  }

}
