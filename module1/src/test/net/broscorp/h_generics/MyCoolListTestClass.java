package net.broscorp.h_generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MyCoolListTestClass {

    MyOwnCoolList<Integer> myOwnCoolList;

    @BeforeEach
    void init() {
        myOwnCoolList = new MyOwnCoolList<>();
        myOwnCoolList.add(111);
    }

    @Test
    void get_ListTest() {
        assertEquals(111, myOwnCoolList.get(0));
    }

    @Test
    void removeListTest() {
        myOwnCoolList.remove(0);
        assertNull(myOwnCoolList.get(0));
    }

    @Test
    void sizeListTest() {
        assertEquals(1, myOwnCoolList.size());
    }

    @Test
    void mapTest() {
        MyOwnCoolList<? extends Number> myOwnCoolListMap = myOwnCoolList.map(x -> x + 111);
        assertEquals(222, myOwnCoolListMap.get(0));
    }
}
