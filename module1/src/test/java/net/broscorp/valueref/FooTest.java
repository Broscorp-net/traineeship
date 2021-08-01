package net.broscorp.valueref;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FooTest {
  //Java хранит примитивы в стеке. Значения стека для переменной num
  //будут хранится в методе foo только на момент его присвоения.
  //Но как только происходит обращение к переменной за пределами метода -
  //значение стека сбрасывается до первоначального.

  @Test
  void fooImmutablePassedParameterTest() {
    int num = 5;
    List<String> stringList = new ArrayList<>();
    Foo foo = new Foo();
    foo.foo(num, stringList);
    int expected = 20;
    Assertions.assertNotEquals(expected, num);
  }

  //Объекты java хранит в "куче", а в стек передаются только ссылки на них.
  //По этому запись значений для объекта будут записаны в данный раздел памяти.
  //Соответственно те значения, которые хранятся в куче изменятся не будут.
  //За уничтожение объектов и их значений в java отвечает garbage collector.

  @Test
  void fooMutablePassedParameterTest() {
    int num = 5;
    List<String> stringList = new ArrayList<>();
    Foo foo = new Foo();
    foo.foo(num, stringList);
    String expected = "d";
    Assertions.assertEquals(expected, stringList.get(0));
  }
}