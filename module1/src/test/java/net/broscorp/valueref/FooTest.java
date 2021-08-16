package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FooTest {

  private ArrayList<String> list;
  private Foo obj;

  @BeforeEach
  void startTest() {
    obj = new Foo();
    list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
  }

  @Test
  void foo() throws Exception {
    obj.foo(10, list);
    assertEquals(4, list.size()); // True

    /* добавляем элемент 'd' в list. Длинна list становиться 4 так
    как у нас было 3 элемента. Значение параметра i останется прежним после вызова
    метода foo().
    Первый параметр передача по значению. Вызываемый метод
    создает свою копию значения аргумента и использует ее, но на исходный параметр
    это никак не влияет.
    Второй параметр передача по ссылке. Вызываемый метод не создает свою копию,
    а ссылается на исходное значение.*/

  }
}