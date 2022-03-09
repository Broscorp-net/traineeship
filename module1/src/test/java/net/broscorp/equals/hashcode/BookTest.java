package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BookTest {

  @Test
  public void checkSomeObject() {
    Book gameOfWar = new Book(1, "Game of War", 5);
    Book gameOfWar2 = new Book(1, "Game of War", 5);
    assertEquals(gameOfWar.hashCode(), gameOfWar2.hashCode());
    assertEquals(gameOfWar, gameOfWar2);
  }

  @Test
  public void checkOtherObject() {
    Book gameOfWar = new Book(1, "Game of War", 5);
    Book gameOfWar2 = new Book(2, "War of Game", 5);
    assertNotEquals(gameOfWar.hashCode(), gameOfWar2.hashCode());
    assertNotEquals(gameOfWar, gameOfWar2);
  }

  @Test
  public void checkSomeHashCodeAndOtherEquals() {
    List<Book> books = new ArrayList<>();
    books.add(new Book(1, "Game of War", 3));
    books.add(new Book(2, "Book_1", 3));
    books.add(new Book(3, "Book_2", 3));
    books.add(new Book(1, "War of War", 3));
    books.add(new Book(5, "Book_3", 3));

    for (Book book : books) {
      int index = books.indexOf(book);
      if (index < books.size() - 1) {
        Book nextBook = books.get(index + 1);
        boolean checkHashCode = book.hashCode() == nextBook.hashCode();
        boolean checkEquals = book.equals(nextBook);
        if (checkHashCode && !checkEquals) {
          System.out.println("Object " + book + " and Object " + book +
              " not equals, but same hashCode");
          assertTrue(checkHashCode);
          assertFalse(checkEquals);
        }
      }
    }
  }
}