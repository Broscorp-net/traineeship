package net.broscorp.i_equals_hashcode;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testReflexiveEqualsBook() { // x.equals(x) should return true
        Book book = new Book("Repka", "Narod");
        assertEquals(book, book);
    }

    @Test
    void testSymmetricEqualsBook() { // x.equals(y) should return true if and only if y.equals(x) returns true
        Book book = new Book("Repka", "Narod");
        Book book2 = new Book("Repka", "Narod");
        assertEquals(book, book2);
        assertEquals(book2, book);
    }

    @Test
    void testTransitiveEqualsBook() { // if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
        Book book = new Book("Repka", "Narod");
        Book book2 = new Book("Repka", "Narod");
        Book book3 = new Book("Repka", "Narod");
        assertEquals(book, book2);
        assertEquals(book2, book3);
        assertEquals(book, book3);
        //System.out.println(book.equals(book2) & book2.equals(book3) & book.equals(book3));
    }

    @Test
    void testConsistentEqualsBook() { // multiple invocations of x.equals(y) consistently return true or consistently return false
        Book book = new Book("Repka", "Narod");
        Book book2 = new Book("Repka", "Narod");
        assertEquals(book, book2);
        assertEquals(book, book2);
        assertEquals(book, book2);
    }

    @Test
    void testConsistentNotEqualsBook() { // multiple invocations of x.equals(y) consistently return true or consistently return false
        Book book = new Book("Repka", "Narod");
        Book book2 = new Book("Repka", "Me");
        assertNotEquals(book, book2);
        assertNotEquals(book, book2);
        assertNotEquals(book, book2);
    }

    @Test
    void testNullNotEqualsBook() { // any non-null reference value x, x.equals(null) should return false
        Book book = new Book("Repka", "Narod");
        Book book2 = null;
        assertNotEquals(book, book2);
    }

    @Test
    void testTenInvocationHashCode() { //  invoked on the same object more than once during an execution of a Java application, the hashCode method must consistently return the same integer
        Book book = new Book("Repka", "Narod");
        int firstHashCode = book.hashCode();
        int lastHashCode = 0;
        for (int i = 0; i < 10; i++) {
            lastHashCode = book.hashCode();
        }
        assertEquals(firstHashCode, lastHashCode);
    }

    @Test
    void testEqualAccordingHashCode() { // If two objects are equal according to the equals() method, then calling the hashCode method on each of the two objects must produce the same integer result.
        Book book = new Book("Repka", "Narod");
        Book book2 = new Book("Repka", "Narod");
        boolean isEquals = book.equals(book2);
        boolean isHashCodeEquals = book.hashCode() == book2.hashCode();
        assertEquals(isEquals, isHashCodeEquals);
    }

    @Test
    void testUnequalAccordingHashCode() { // if two objects are unequal according to the equals() method, then calling the hashCode method on each of the two objects must produce distinct integer results.
        Book book = new Book("Repka", "Narod");
        Book book2 = new Book("Repka", "Me");
        assertNotEquals(book.hashCode(), book2.hashCode());
        assertNotEquals(book.hashCode(), book2.hashCode());
    }

/*    @Test
    void testCoincidenceHashCode() {
        Book book = new Book("Repka", "Narod");
        Book book2 = new Book("Repka", "Me");
        ArrayList bookList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            bookList.add(book);
            for (int j = 0; j < 5; j+=3) {
                bookList.add(book2);
            }
        }
        int coincidence = 0;
        int b = bookList.get(0).hashCode();
        for (int i = 1; i < bookList.size(); i++) {
            int a = bookList.get(i).hashCode();
            if (a == b) coincidence++;
        }
        System.out.println(coincidence);

        assertEquals(4, coincidence);
    }*/
}
