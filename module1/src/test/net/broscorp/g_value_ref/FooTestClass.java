package net.broscorp.g_value_ref;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FooTestClass {
    Foo fooClass = new Foo();
    List<String> list = new ArrayList<>();
    int i;

//Primitive types are sending by values
    @Test
    void fooPrimitiveTest() {
        i = 100;
        fooClass.foo(i, list);
        assertEquals(i, 100);
    }
//Objects in Java sending by copies of references
    @Test
    void fooArrayListTest() {
        fooClass.foo(i, list);
        assertEquals(list.get(0), "d");
    }
}

