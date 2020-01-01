package net.broscorp.h_generics;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MyCoolListTestClass {
    MyCoolList<Integer> myCoolList;

    @BeforeEach
    void init() {
        myCoolList = new MyCoolList<>();
        myCoolList.add(111);
    }

    @Test
    void get_ListTest() {
        assertEquals(111, myCoolList.get(0));
    }

    @Test
    void removeListTest() {
        myCoolList.remove(0);
        assertNull(myCoolList.get(0));
    }

    @Test
    void sizeListTest() {
        assertEquals(1, myCoolList.size());
    }

    @Ignore//try to play with annotations
    @Test
    void mapTest() {
        myCoolList = new MyCoolList<>();
        myCoolList.add(111);
        MyCoolList<? extends Number> myCoolListMap = myCoolList.map(x -> x + 111);
        assertEquals(222, myCoolListMap.get(0));
    }
}
