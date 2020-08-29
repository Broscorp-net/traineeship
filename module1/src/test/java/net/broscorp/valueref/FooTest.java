package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import net.broscorp.valueref.Foo;
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
    net.broscorp.valueref.Foo foo = new net.broscorp.valueref.Foo();
    foo.foo(number, list);
    assertNotEquals(expectNumber, number);
  }
  // изменение переменной произошло только внутри метода (локальной i)


  @Test
  void listSizeTest() {
    net.broscorp.valueref.Foo foo = new net.broscorp.valueref.Foo();
    foo.foo(number, list);
    assertTrue(list.size() == 4);
  }

  @Test
  void listValuesTest() {
    net.broscorp.valueref.Foo foo = new Foo();
    foo.foo(number, list);
    assertTrue(list.contains("d"));
  }
  // тесты списка подтверждают изменения согласно логике метода
  // обьекты передаются по ссылке, действия внутри метода foo меняют и объект
}