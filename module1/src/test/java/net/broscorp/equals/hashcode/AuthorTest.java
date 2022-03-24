package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AuthorTest {

  private static List<Author> list;
  private static Author author1;
  private static Author author2;
  private static Author author3;


  @BeforeAll
  public static void setup() {
    list = new ArrayList<>();
    author1 = new Author("Taras Shevchenko", "Kobzar");
    author2 = new Author("Taras Shevchenko", "Kobzar");
    author3 = new Author("Taras Shevchenko", "Kobzar");
    Author author4 = new Author("Lesia Ukrainka", "Lisova Mavka");
    Author author5 = new Author("Nikolay Gogolb", "Mertvie Dushi");
    list.add(author1);
    list.add(author4);
    list.add(author5);
  }

  @Test
  void reflectionTest() {
    assertEquals(author1, author1);
    assertEquals(author1.hashCode(), author2.hashCode());
  }

  @Test
  void nullTest() {
    Assertions.assertNotNull(author1);
  }

  @Test
  void symmetric() {
    assertEquals(author1, author2);
    assertEquals(author2, author1);
    assertEquals(author1.hashCode(), author2.hashCode());
    assertEquals(author2.hashCode(), author1.hashCode());
  }

  @Test
  void transitive() {
    assertEquals(author1, author2);
    assertEquals(author2, author3);
    assertEquals(author1, author3);
    assertEquals(author1.hashCode(), author2.hashCode());
    assertEquals(author2.hashCode(), author3.hashCode());
    assertEquals(author1.hashCode(), author3.hashCode());
  }

  @Test
  void consistent() {
    assertEquals(author1, author2);
    assertEquals(author1, author2);
    assertEquals(author1, author2);
    assertEquals(author1.hashCode(), author2.hashCode());
    assertEquals(author1.hashCode(), author2.hashCode());
    assertEquals(author1.hashCode(), author2.hashCode());
  }

  @Test
  void testCollision() {
    StringBuilder message = new StringBuilder();
    for (int j = 0; j < list.size(); j++) {
      for (int i = j + 1; i < list.size(); i++) {
        if (list.get(j) != list.get(i)
            && list.get(j).hashCode() == list.get(i).hashCode()) {
          Assertions.assertNotEquals(list.get(j), list.get(i));
          assertEquals(list.get(j).hashCode(), list.get(i).hashCode());
          message.append("Вот объект ")
              .append(list.get(j))
              .append(" , вот объект ")
              .append(list.get(i))
              .append(" , они разные, но их хеш сопадает");
          System.out.println(message);
        }
      }
    }
  }
}
