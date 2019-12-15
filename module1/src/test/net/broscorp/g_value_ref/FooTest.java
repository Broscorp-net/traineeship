package net.broscorp.g_value_ref;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FooTest {

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
        Foo foo = new Foo();
        int i = 100;
        List<String> iAmList = new ArrayList<>();
        foo.foo(i, iAmList); // тут я утверждаю, что кол-во индексов в iAmList до вызова метода = 0
                            // и после вызова поменяется на +1
        assertNotEquals(0, iAmList.size());
    }

    @Test
    void fooValue() {
        Foo foo = new Foo();
        List<String> beforeStr = new ArrayList<>();
        int i = 100;
        foo.foo(i, beforeStr); // из метода класса Foo кажется, будто i = 100 + 15, но это не так
        assertNotEquals(115, i);
    }
}