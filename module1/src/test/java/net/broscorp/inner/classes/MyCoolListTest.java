package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

class MyCoolListTest {

    @Test
    void iterator() {
        MyCoolList<Integer> list = new MyCoolList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator iterator = list.iterator();

    for (int i = 0; i < list.size(); i++) {

        assertTrue(iterator.next() == list.get(i));
    }
    }
}