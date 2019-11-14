import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FooTests {

    private static Foo tester;

    @BeforeAll
    public static void initTestedClass() {
        tester = new Foo();
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        int i = 0;
        List<String> strList = null;

        assertThrows(NullPointerException.class, () -> {
            tester.foo(i, strList);
        });
    }

    @Test
    public void whenExceptionDoesNotThrown_thenAssertionSucceeds() {
        int i = 0;
        List<String> strList = new ArrayList<>();

        assertDoesNotThrow( () -> {
            tester.foo(i, strList);
        });
    }

    // strList - параметр оберточного типа,
    // они передают методу ссылку на значение (адрес переменной)
    // поэтому метод может изменить список
    @Test
    public void whenOneElementAddedToListParam_thenAssertionSucceeds() {
        int i = 0;
        List<String> strList = new ArrayList<>();
        int expectedListSize = strList.size() + 1;
        tester.foo(i, strList);

        assertEquals(strList.size(), expectedListSize);
    }

    // параметр i - переменная примитивного типа,
    // поэтому метод получает и оперирует только значение
    // и значение меняется тоько внутри, но не за пределами метода
    @Test
    public void whenIntParamNotChangeValue_thenAssertionSucceeds() {
        int i = 0;
        List<String> strList = new ArrayList<>();
        int expectedValue = i;
        tester.foo(i, strList);

        assertEquals(i, expectedValue);
    }

}
