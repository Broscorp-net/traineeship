package net.broscorp.l_inner_classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyIteratorTestClass {
    MyCoolList<Integer> myCoolList;
    Iterator<Integer> integerIterator;

    @BeforeEach
    void init() {
        myCoolList = new MyCoolList<>();
        integerIterator = myCoolList.iterator();
    }

    @Test
    void iteratorHasNextFalseTest() {
        assertFalse(integerIterator.hasNext());
    }

    @Test
    void iteratorHasNextTrueTest() {
        myCoolList.add(1);
        assertTrue(integerIterator.hasNext());
    }

    @Test
    void iteratorNextText() {
        myCoolList.add(1);
        myCoolList.add(1);
        integerIterator.next();
        integerIterator.next();
        assertThrows(NoSuchElementException.class, () -> integerIterator.next());
    }
}

