package net.broscorp.g_value_ref;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FooTest {

    Foo foo = new Foo();

    @Test
    void foo() {
        int i = 100;
        List<String> s = new ArrayList<>();
        s.add("c");
        System.out.print("Before method income ");
        System.out.print("i = " + i);
        System.out.println(", s = " + s);
        /**
         * В метод передается копия значения переменной "int i" и копия ссылки "s"
         * на массив списка строк "ArrayList". В методе "foo()" создается новая переменная
         * которой присваивается значение 115, но это значение не возвращается в переданную
         * переменную, поэтому int i = 100 не поменялось после отработки метода.
         * А значение объекта пеменялось на [c, d], так как обе ссылки получили доступ к
         * одному объекту в памяти и могут влиять на его содержимое.
         */
        foo.foo(i, s);
        System.out.print("After method income ");
        System.out.print("i = " + i);
        System.out.println(", s = " + s);

    }
}