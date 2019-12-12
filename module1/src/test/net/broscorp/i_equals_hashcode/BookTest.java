package net.broscorp.i_equals_hashcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testReflexiveEqualsBook() { // x.equals(x) should return true
        Book book = new Book(0, "Repka");
        assertEquals(book, book);
    }

    @Test
    void testSymmetricEqualsBook() { // x.equals(y) should return true if and only if y.equals(x) returns true
        Book book = new Book(0, "Repka");
        Book book2 = new Book(1, "Kolobok");
        assertEquals(book, book2);
        assertEquals(book2, book);
    }

    @Test
    void testTransitiveEqualsBook() { // if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
        Book book = new Book(0, "Repka");
        Book book2 = new Book(1, "Kolobok");
        Book book3 = new Book(2, "Buratino");
        assertEquals(book, book2);
        assertEquals(book2, book3);
        assertEquals(book, book3);
    }

    @Test
    void testConsistentEqualsBook() { // multiple invocations of x.equals(y) consistently return true or consistently return false
        Book book = new Book(0, "Repka");
        Book book2 = new Book(1, "Narod");
        assertEquals(book, book2);
        assertEquals(book, book2);
        assertEquals(book, book2);
    }

    @Test
    void testConsistentNotEqualsBook() { // multiple invocations of x.equals(y) consistently return true or consistently return false
        Book book = new Book(0, "Narod");
        Book book2 = new Book(1, "Me");
        assertNotEquals(book, book2);
        assertNotEquals(book, book2);
        assertNotEquals(book, book2);
    }

    @Test
    void testNullNotEqualsBook() { // any non-null reference value x, x.equals(null) should return false
        Book book = new Book(0, "Repka");
        Book book2 = null;
        assertNotEquals(book, book2);
    }

    @Test
    void testTenInvocationHashCode() { //  invoked on the same object more than once during an execution of a Java application, the hashCode method must consistently return the same integer
        Book book = new Book(0, "Repka");
        int firstHashCode = book.hashCode();
        int lastHashCode = 0;
        for (int i = 0; i < 10; i++) {
            lastHashCode = book.hashCode();
        }
        assertEquals(firstHashCode, lastHashCode);
    }

    @Test
    void testEqualAccordingHashCode() { // If two objects are equal according to the equals() method, then calling the hashCode method on each of the two objects must produce the same integer result.
        Book book = new Book(0, "Repka");
        Book book2 = new Book(1, "Repka");
        boolean isEquals = book.equals(book2);
        boolean isHashCodeEquals = book.hashCode() == book2.hashCode();
        assertEquals(isEquals, isHashCodeEquals);
    }

    @Test
    void testUnequalAccordingHashCode() { // if two objects are unequal according to the equals() method, then calling the hashCode method on each of the two objects must produce distinct integer results.
        Book book = new Book(0, "Repka");
        Book book2 = new Book(1, "Kolobok");
        assertFalse(book.equals(book2));
        assertFalse(book.hashCode() == book2.hashCode());
    }

    int count1 = 0;
    int count2 = 0;

    @Test
    void testCoincidenceHashCode() {
        Set<Book> set = new HashSet<>();
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> mapTwice = new HashMap<>();

        for (int i = 0; i < 1_500_000; i++) {
            int numb = (int) Math.round(Math.random() * 1_000_000);
            Book book = new Book(numb, "Repka");
            set.add(book);
            /**
             * Тут игнорируем объекты с совпадающими хешами
             */
            if (!map.containsKey(book.hashCode())) {
                map.put(book.hashCode(), "Book # " + i);
            } else {
                /**
                 * Сюда складываем объекты с совпавшими хешами
                 */
                mapTwice.put(book.hashCode(), "TwiceBook " + i);
            }
        }
        assertEquals(set.size(), map.size());
        assertNotEquals(map.size(), mapTwice.size());
    }
}
