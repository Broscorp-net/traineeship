package net.broscorp.valueref;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class содержит методы для тестирования класса Foo
 *
 * @author Volodymyr Lopachak
 * @version 1.0
 */
class FooTest {
    private static Foo foo;
    private static List<String> list;

    @BeforeAll
    public static void init() {
        foo = new Foo();
        list = new ArrayList<>(Arrays.asList("One", "Two"));
    }

    /**
     * Так как в Java примитивные типы передаются по значению, тоесть в метод передаётся фактически копия
     * переменной, и любые манипуляции с этим переданным значением никак не влияют на значение переменной,
     * которая была изначально передана м метод foo, что демонстрирует данный тест;
     */
    @Test
    public void testFooToValue() {
        int i = 10;
        foo.foo(i, list);
        assertEquals(10, i);
    }

    /**
     * Так как в Java объекты (а коллекции являются объектами) передаются по ссылке - тоесть в метод
     * передаётся не сам объект, а ссылка на него, поэтому все изменения, что произошли с объектом
     * в другом месте - отображаются везде, где используется на него ссылка, что подтверждает данный тест;
     */
    @Test
    public void testFooToLink() {
        int i = 10;
        final int listSizeBefore = list.size();
        foo.foo(i, list);
        final int listSizeAfter = list.size();
        assertNotEquals(listSizeBefore, listSizeAfter);
    }

}