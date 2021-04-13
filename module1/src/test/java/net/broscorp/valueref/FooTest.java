package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Junit5 Foo")
class FooTest {

  @Test
    void foo() {
    int num = 5;
    List<String> actual = new ArrayList<>();
    List<String> expected = new ArrayList<>();
    expected.add("d");
    Foo foo = new Foo();
    foo.foo(num, actual);
    Assertions.assertSame(5, num); //примитивные типы передаются по значению,
    // изменения в методе не изменят переменную вне метода.
    Assertions.assertEquals(expected, actual);//объекты передаются по ссылке,
    // изменения в методе повлияют на объект вне метода.
  }
}