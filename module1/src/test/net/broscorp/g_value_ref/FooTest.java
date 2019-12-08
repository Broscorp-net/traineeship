package net.broscorp.g_value_ref;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FooTest {

    Foo foo = new Foo();
    int beforeNum = 100; // beforeNum, beforeStr - сохранить состояние до вызова метода
    List<String> beforeStr = new ArrayList<>();

    /**
     * В метод передается копия значения переменной "int i" и копия ссылки "s"
     * на массив списка строк "ArrayList". В методе "foo()" создается новая переменная,
     * которой присваивается значение 115, но это значение не возвращается в переданную
     * переменную, поэтому int i = 100 не поменялось после отработки метода.
     * А значение объекта пеменялось на [d], так как обе ссылки получили доступ к
     * одному объекту в памяти и могут влиять на его содержимое.
     */
    @Test
    void fooRef() {
        List<String> s = new ArrayList<>();
        beforeStr = s;
        foo.foo(beforeNum, s);
        assertEquals(beforeStr, s);
    }

    @Test
    void fooValue() {
        int i = 100;
        beforeNum = i;
        foo.foo(beforeNum, beforeStr);
        assertEquals(beforeNum, i);
    }
}