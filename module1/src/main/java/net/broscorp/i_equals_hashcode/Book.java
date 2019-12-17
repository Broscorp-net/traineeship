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
        int hashName = 0;
        if (name.length() % 2 == 0) {
            hashName = 1;
        } else {
            hashName = 2;
        }
        int result = id + hashName;
        return result;
    }

    Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
