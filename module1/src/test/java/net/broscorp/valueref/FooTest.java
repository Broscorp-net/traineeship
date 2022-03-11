package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FooTest {
  private Foo foo;

  @BeforeEach
  public void setUp() {
    foo = new Foo();
  }

  @Test
  public void shouldBeNotEmpty() {
    List<String> someList = new ArrayList<>(); // передаётся копия ссылки
    foo.foo(1, someList); // которая влияет на вн. объект
    Assertions.assertFalse(someList.isEmpty()); // т.о. список не пустой
  }

  @Test
  public void integerWontIncrement() {
    int i = 1; // обратная ситуация с примитивами
    foo.foo(i, new ArrayList<>()); // передаётся копия переменной
    Assertions.assertFalse(i == 16); // т.о. значение останется прежним
  }
}
