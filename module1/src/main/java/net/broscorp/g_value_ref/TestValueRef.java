package net.broscorp.g_value_ref;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestValueRef {

    private Foo someFoo = new Foo();
    private int someValue = 10;
    private List<String> list = new LinkedList<>();

    @Test
    public void testOfValueReflationUsingFooMethod(){
        int expectedValue = someValue;
        someFoo.foo(someValue, list);
        assertEquals(expectedValue, someValue);
        assertEquals("d", list.get(0));
    }
}
