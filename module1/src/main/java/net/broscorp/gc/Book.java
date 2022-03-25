package net.broscorp.gc;

import lombok.Data;

@Data
public class Book {

  private int numberOfPages;

  public Book(int numberOfPages) {
    this.numberOfPages = numberOfPages;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Book with -> " + numberOfPages + " pages deleted");
  }
}
