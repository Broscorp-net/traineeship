package net.broscorp.equals.hashcode;

public class Book {

  private final int id;
  private final String name;
  private final int amount;

  public Book(int id, String name, int amount) {
    this.id = id;
    this.name = name;
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Book book = (Book) o;

    if (id != book.id) {
      return false;
    }
    if (amount != book.amount) {
      return false;
    }
    return name != null ? name.equals(book.name) : book.name == null;
  }

  @Override
  public int hashCode() {
    return name.hashCode() + id;
  }

  @Override
  public String toString() {
    return "Name : " + name + ". Amount : " + amount;
  }
}
