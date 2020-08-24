package net.broscorp.valueref;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FooUnitTests {

    int actual;
    int expected;
    List<String> actualList;

    @BeforeEach
    public void before() {
        actual = 15;
        expected = 30;
        actualList = new ArrayList<>();
        actualList.add("a");
        actualList.add("b");
        actualList.add("c");
    }

    //В метод передаётся копия примитивного типа, поэтому изменений с actual никаких не происходит
    @Test
    public void checkPrimitivesValue() {
        Foo clazz = new Foo();
        clazz.foo(actual, actualList);
        Assertions.assertNotEquals(expected, actual);
    }

    //В метод передаётся ссылка на actualList, соответственно изменения происходят внутри actualList, а не в его копии
    @Test
    public void contentCheck() {
        Foo clazz = new Foo();
        clazz.foo(actual, actualList);
        Assertions.assertTrue(actualList.contains("d"));
    }
}
