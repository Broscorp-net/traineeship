package net.broscorp.f_boxing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoxingUnboxingTest {

    @Test
    void testAutoBoxingIntegers() {
        int i = 1;
        List<Integer> list = new ArrayList<>();
        list.add(i);
        assertEquals(1, list.get(0));
    }

    @Test
    void testUnBoxingIntegers() {
        Integer value1 = 200;
        Integer value2 = 200;
        int result = value1 + value2;

        assertEquals(400, result);

    }
}
