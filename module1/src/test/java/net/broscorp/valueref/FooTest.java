package net.broscorp.valueref;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class FooTest {
    @Test
    void foo() {
        Foo foo = new Foo();
        int i = 1;

        List<String> list = new ArrayList<>();

        foo.foo(i, list);

        assertSame(1, i);
        //Variables on the stack exist as long as the method in which they were created is executed
        assertEquals("d", list.get(list.indexOf("d")));
    }

}
