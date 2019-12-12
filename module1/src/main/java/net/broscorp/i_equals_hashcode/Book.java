package net.broscorp.i_equals_hashcode;

import java.util.Objects;

public class Book {

    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(name, book.name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 31 + id;
        result = 31 * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
