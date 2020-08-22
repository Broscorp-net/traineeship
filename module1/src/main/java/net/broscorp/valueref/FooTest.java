package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FooTest {
  private Foo foo = new Foo();
  private int a = 10;
  private List<String> list = new ArrayList();

  @Test
  void foo() {
    foo.foo(a,list);
    assertEquals(10,a);
    // int не является ссылочным типом, так что в метод
    // передается копия примитива и его значение меняется только внутри метода
    assertFalse(list.isEmpty());
    // List является ссылочным типом и ссылка, которая передается в метод,
    // указывает на изначальный обьект. Изменения внутри метода меняют глобальное состояние
  }
}