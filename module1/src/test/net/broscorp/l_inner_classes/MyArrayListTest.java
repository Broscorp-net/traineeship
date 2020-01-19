package net.broscorp.l_inner_classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    private MyArrayList<Float> myArrayList;
    private Iterator<Float> iterator;

    @BeforeEach
    void setUp() {
        myArrayList = new MyArrayList<>();
        iterator = myArrayList.iterator();
    }

    @Test
    void testIterator() {
        for (int i = 1; i <= 5; i++) {
            myArrayList.add(i * 100F);
        }
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        String expectRes = "MyArrayList{elements=[100.0, 200.0, 300.0, 400.0, 500.0]}";
        String actual = myArrayList.toString();
        assertEquals(expectRes, actual);
    }

    @Test
    void testTrueHasNext() {
        myArrayList.add(5.1F);
        Object actual = iterator.hasNext();
        assertEquals(true, actual);
    }

    @Test
    void testFalseHasNext() {
        Object actual = iterator.hasNext();
        assertEquals(false, actual);
    }

    @Test
    void testNext() {
        myArrayList.add(10.5F);
        float expectRes = 10.5F;
        Object actual = iterator.next();
        assertEquals(expectRes, actual);
    }
}