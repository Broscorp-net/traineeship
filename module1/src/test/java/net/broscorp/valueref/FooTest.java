package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FooTest {

  private Foo foo;
  private int firstParamFoo;
  private List<String> ls;

  @BeforeEach
  void init() {
    foo = new Foo();
    firstParamFoo = 1;
    ls = new ArrayList<>();
    ls.add("abc");
    ls.add("bc");
  }

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
    int firstParamBeforeFoo = firstParamFoo;
    int sizeListBeforeFoo = ls.size();
    final List<String> listBeforeFoo = ls;
    foo.foo(firstParamFoo, ls);
    int firstParamAfterFoo = firstParamFoo;
    int sizeListAfterFoo = ls.size();

    // compare value first parameter before and after method call
    assertEquals(firstParamBeforeFoo, firstParamAfterFoo);
    // List's size increase by 1
    assertEquals(sizeListBeforeFoo + 1, sizeListAfterFoo);
    // compare references on List
    assertSame(listBeforeFoo, ls);
  }
}