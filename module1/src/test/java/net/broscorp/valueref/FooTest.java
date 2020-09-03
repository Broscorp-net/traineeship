package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FooTest {

  Foo foo;
  int number;
  int expectNumber;
  ArrayList<String> list;

  @BeforeEach
  void initDataBeforeEachTest() {
    foo = new Foo();
    number = 5;
    expectNumber = number + 15;
    list = new ArrayList<>();
    list.add("string1");
    list.add("string2");
    list.add("string3");
  }

  // изменение переменной происходит только внутри метода (локальной i)
  @Test
  void intChangeValueTest() {
    foo.foo(number, list);
    assertNotEquals(expectNumber, number);
  }

  // проверяем, что метод foo вносит изменения в список
  @Test
  void listChangeSizeTest() {
    foo.foo(number, list);
    assertTrue(list.size() == 4);
  }

  // проверяем, что добавлен елемент "d"
  @Test
  void listChangeValuesTest() {
    foo.foo(number, list);
    assertTrue(list.contains("d"));
  }
  // тесты списка подтверждают изменения согласно логике метода
  // обьекты передаются по ссылке, действия внутри метода foo меняют и объект
}
