package net.broscorp.valueref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FooTest {
  /**
  * Java передает параметры только по значению. При этом в качестве аргументов Java использует
  * не сами переменные, а их копии. Память в Java разделена на два типа: stack и heap.
  * Все переменные примитивных типов хранятся в stackе вместе с их значениями, а переменные
  * ссылочного типа в качестве значения хранят в stackе адреса ячеек памяти heapе.
  * Следовательно, при вызове метода Java делает копию примитивной переменной, переменная
  * создается в stackе, Java с ней работает, а на исходную переменную никакого влияния нет.
  * А в случае со списком Java копирует значение этой переменной со stackа, а там
  * хранится адрес ячейки heap. Получается, что и исходная переменная и копия сделанная Java
  * ссылаются на одну и ту же ячейку, а значит и действия произведенные с копией повлияют на
  * исходную переменную.*/
  @Test
  void newTest() {
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    int num = 5;
    Foo foo = new Foo();
    String beforeMethod = list.toString();
    foo.foo(num, list);
    String afterMethod = list.toString();
    assertEquals(5, num);
    assertNotEquals(beforeMethod, afterMethod);
    assertNotEquals(20, num);
  }

}