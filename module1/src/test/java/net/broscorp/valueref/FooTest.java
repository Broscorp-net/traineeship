package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FooTest {

  /*
  Параметр i в методе foo() является примитивом и передается по значению, т.е. в метод передается
  копия этой переменной. Метод будет работать с копией и после завершения работы копия уничтожится.
  Оригинальная переменная i свое значение не изменит.
  Второй параметр метода является ссылочным, он фактически хранится в куче, а ссылка на него в стеке
  При передаче параметров в метод передается копия ссылки (адреса в куче) на List. Метод будет
  работать с объектом List используя копию ссылки, а по окончании работы копия уничтожится, но List
  сохранится со всеми изменениями, т.к. сохранится оригинальнвая ссылка на него.
  */
  @Test
  void fooTest() {

    int firstParamFoo = 1;
    List<String> ls = new ArrayList<>();
    ls.add("abc");
    ls.add("bc");
    Foo foo = new Foo();
    int sizeListBeforeFoo = ls.size();

    foo.foo(firstParamFoo, ls);

    // check value of primitive, it did not increase by 15
    assertNotEquals(16, firstParamFoo);
    // List's size increase by 1
    assertEquals(sizeListBeforeFoo + 1, ls.size());
    // ArrayList now contains "d"
    assertTrue(ls.contains("d"));
  }
}