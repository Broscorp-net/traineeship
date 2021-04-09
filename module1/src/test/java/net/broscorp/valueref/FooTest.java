package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Junit5 Foo")
class FooTest {

  private int num;
  private List<String> actual;
  private List<String> expected;

  @BeforeAll
    void setUp() {
    num = 5;
    actual = new ArrayList<>();
    expected = new ArrayList<>();
    expected.add("d");
  }

  @Test
    void foo() {
    Foo foo = new Foo();
    foo.foo(num, actual);
    Assertions.assertSame(5, num); //примитивные типы передаются по значению,
    // изменения в методе не изменят переменную вне метода.
    Assertions.assertEquals(expected, actual);//объекты передаются по ссылке,
    // изменения в методе повлияют на объект вне метода.
  }
}