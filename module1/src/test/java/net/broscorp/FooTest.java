package net.broscorp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import net.broscorp.valueref.Foo;

import org.junit.jupiter.api.Test;

public class FooTest {

  @Test
  void fooTest() {
    Foo instance = new Foo();

    List<String> objectsList = new ArrayList<>(3);
    instance.foo(1, objectsList);

    assertEquals("d", objectsList.get(0));
  }
}

/*
Для вызова метода foo необходимо создать обьект(ссылку) класса Foo.
После чего вызываем метод foo у данного обьекта и передаем как аргумент ссылку на лист строк,
который создан в предыдущей строке
 */