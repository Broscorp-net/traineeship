package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FooTest {

  int number;
  int expectNumber;
  ArrayList<String> list;

  @BeforeEach
  void prepare() {
    number = 5;
    expectNumber = number + 15;
    list = new ArrayList<>();
    list.add("string1");
    list.add("string2");
    list.add("string3");
  }

  @Test
  void intValueTest() {
    Foo foo = new Foo();
    foo.foo(number, list);
    assertEquals(expectNumber, number);
  }
  // тест падает т.к. изменение переменной произошло только внутри метода (локальной i)


  @Test
  void listSizeTest() {
    Foo foo = new Foo();
    foo.foo(number, list);
    assertTrue(list.size() == 4);
  }

  @Test
  void listValuesTest() {
    Foo foo = new Foo();
    foo.foo(number, list);
    assertTrue(list.contains("d"));
  }
  // тесты списка подтверждают изменения согласно логике метода
  // обьекты передаются по ссылке, действия внутри метода foo меняют и объект
}