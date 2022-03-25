package net.broscorp.gc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTest {


  @Test
  void createManyBooks() {
    for (int i = 1; i < 1_300_000; i++) {
      new Book(i);
    }
  }

  @Test
  void createAndDeleteBooksGc() {
    for (int i = 1; i < 10_000; i++) {
      Book book = new Book(i);
      book = null;
    }
    System.gc();
  }

  @Test
  void makeBookReachableAgainAfterFinalization() {
    Book book = new Book(77);
    book = null;
    System.gc();
    book = new Book(88);
    System.out.println(book);
    Assertions.assertNotNull(book);
  }

  @Test
  void deletePairsOfBooksWithSameLink() {
    Book book1 = new Book(100);
    Book book2 = new Book(200);
    book1 = book2;
    book2 = book1;
    book1 = null;
    book2 = null;
    System.gc();
  }
}
