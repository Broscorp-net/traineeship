package net.broscorp.equals.hashcode;

public class Author {
  private String name;
  private String book;

  public Author() {
  }

  public Author(String name, String book) {
    this.name = name;
    this.book = book;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBook() {
    return book;
  }

  public void setBook(String book) {
    this.book = book;
  }

  @Override
  public boolean equals(Object author) {
    if (author == this) {
      return true;
    }
    if (author == null) {
      return false;
    }
    if (author.getClass().equals(Author.class)) {
      Author current = (Author) author;
      return this.name.equals(current.name)
          && this.book.equals(current.book);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (name == null  ? 0 : name.hashCode());
    result = 31 * result + (book == null ? 0 : book.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "Author :"
        + "name = "
        + name
        + ", book = "
        + book;
  }
}
